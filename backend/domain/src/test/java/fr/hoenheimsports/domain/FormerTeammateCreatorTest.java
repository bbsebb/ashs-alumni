package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.api.commands.ContextDetails;
import fr.hoenheimsports.domain.api.commands.CurrentUser;
import fr.hoenheimsports.domain.api.commands.FormerTeammateRegistrationRequest;
import fr.hoenheimsports.domain.exceptions.FormerTeammateAlreadyExistsException;
import fr.hoenheimsports.domain.models.*;
import fr.hoenheimsports.domain.services.FormerTeammateCreator;
import fr.hoenheimsports.domain.services.validations.FormerTeammateUniquenessValidationService;
import fr.hoenheimsports.domain.spi.stubs.FormerTeammateRepositoryStub;
import fr.hoenheimsports.domain.spi.stubs.GenerateIdStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("FormerTeammateCreator Tests")
class FormerTeammateCreatorTest {

    private FormerTeammateCreator formerTeammateCreator;
    private FormerTeammateRepositoryStub formerTeammateRepository;

    private String testFirstName;
    private String testLastName;
    private String testPhone;
    private String testEmail;
    private LocalDate testBirthDate;

    @BeforeEach
    void setUp() {
        // Setup stubs
        formerTeammateRepository = new FormerTeammateRepositoryStub();
        GenerateIdStub idGenerator = new GenerateIdStub();
        
        // Create service under test
        var uniquenessValidationService = new FormerTeammateUniquenessValidationService(formerTeammateRepository);
        formerTeammateCreator = new FormerTeammateCreator(idGenerator, formerTeammateRepository, uniquenessValidationService);

        // Setup test data
        UUID testId = UUID.randomUUID();
        testFirstName = "John";
        testLastName = "Doe";
        testPhone = "+33123456789";
        testEmail = "john.doe@example.com";
        testBirthDate = LocalDate.of(1990, 1, 1);
    }

    @Test
    @DisplayName("Should create FormerTeammate successfully with all fields")
    void shouldCreateFormerTeammateSuccessfully() {
        // Given
        var command = createCommand(testFirstName, testLastName, testPhone, testEmail, testBirthDate, List.of(Role.PLAYER));
        var context = createContextWithUser();

        // When
        var result = formerTeammateCreator.createFormerTeammate(command, context);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.firstName()).isEqualTo(testFirstName);
        assertThat(result.lastName()).isEqualTo(testLastName);
        assertThat(result.phone()).hasValue(new Phone(testPhone));
        assertThat(result.email()).hasValue(testEmail);
        assertThat(result.birthDate()).hasValue(testBirthDate);
        assertThat(result.roles()).containsExactly(Role.PLAYER);
        assertThat(result.status()).isEqualTo(ContactStatus.SUBMITTED);
        
        // Verify saved in repository
        var saved = formerTeammateRepository.findById(result.id());
        assertThat(saved).isPresent();
        assertThat(saved.get()).isEqualTo(result);
    }

    @Test
    @DisplayName("Should create FormerTeammate with minimal fields")
    void shouldCreateFormerTeammateWithMinimalFields() {
        // Given
        var command = createCommand(testFirstName, testLastName, null, null, null, List.of());
        var context = createContextWithoutUser();

        // When
        var result = formerTeammateCreator.createFormerTeammate(command, context);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.firstName()).isEqualTo(testFirstName);
        assertThat(result.lastName()).isEqualTo(testLastName);
        assertThat(result.phone()).isEmpty();
        assertThat(result.email()).isEmpty();
        assertThat(result.birthDate()).isEmpty();
        assertThat(result.roles()).isEmpty();
        assertThat(result.status()).isEqualTo(ContactStatus.SUBMITTED);
    }

    @ParameterizedTest
    @MethodSource("provideGenderScenarios")
    @DisplayName("Should handle different gender values correctly")
    void shouldHandleDifferentGenders(Gender gender, String description) {
        // Given
        var command = new FormerTeammateRegistrationRequest(
                gender,
                testFirstName,
                testLastName,
                null,
                null,
                null,
                List.of()
        );
        var context = createContextWithoutUser();

        // When
        var result = formerTeammateCreator.createFormerTeammate(command, context);

        // Then
        assertThat(result.gender()).isEqualTo(gender);
    }

    @Test
    @DisplayName("Should throw exception when FormerTeammate already exists by name")
    void shouldThrowExceptionWhenFormerTeammateExistsByName() {
        // Given
        var existingFormerTeammate = createTestFormerTeammate(testFirstName, testLastName);
        formerTeammateRepository.save(existingFormerTeammate);
        
        var command = createCommand(testFirstName, testLastName, testPhone, testEmail, testBirthDate, List.of(Role.PLAYER));
        var context = createContextWithUser();

        // When & Then
        assertThatThrownBy(() -> formerTeammateCreator.createFormerTeammate(command, context))
                .isInstanceOf(FormerTeammateAlreadyExistsException.class)
                .hasMessageContaining("Le contact existe déjà; id:");
    }

    @Test
    @DisplayName("Should throw exception when FormerTeammate already exists by phone")
    void shouldThrowExceptionWhenFormerTeammateExistsByPhone() {
        // Given
        var existingFormerTeammate = createTestFormerTeammateWithPhone(testPhone);
        formerTeammateRepository.save(existingFormerTeammate);
        
        var command = createCommand(testFirstName, testLastName, testPhone, testEmail, testBirthDate, List.of(Role.PLAYER));
        var context = createContextWithUser();

        // When & Then
        assertThatThrownBy(() -> formerTeammateCreator.createFormerTeammate(command, context))
                .isInstanceOf(FormerTeammateAlreadyExistsException.class)
                .hasMessageContaining("Le contact existe déjà avec le numéro de téléphone :");
    }

    @ParameterizedTest
    @MethodSource("provideInvalidNameScenarios")
    @DisplayName("Should handle various name combinations for uniqueness check")
    void shouldHandleNameUniquenessCorrectly(String firstName, String lastName, boolean shouldThrow, String description) {
        // Given
        var existingFormerTeammate = createTestFormerTeammate("John", "Doe");
        formerTeammateRepository.save(existingFormerTeammate);
        
        var command = createCommand(firstName, lastName, testPhone, testEmail, testBirthDate, List.of(Role.PLAYER));
        var context = createContextWithUser();

        // When & Then
        if (shouldThrow) {
            assertThatThrownBy(() -> formerTeammateCreator.createFormerTeammate(command, context))
                    .isInstanceOf(FormerTeammateAlreadyExistsException.class);
        } else {
            assertThatCode(() -> formerTeammateCreator.createFormerTeammate(command, context))
                    .doesNotThrowAnyException();
        }
    }

    @Test
    @DisplayName("Should generate unique ID for each creation")
    void shouldGenerateUniqueIdForEachCreation() {
        // Given
        var command1 = createCommand("John", "Doe", testPhone, testEmail, testBirthDate, List.of(Role.PLAYER));
        var command2 = createCommand("Jane", "Smith", "+33987654321", "jane@example.com", testBirthDate, List.of(Role.COACH));
        var context = createContextWithUser();

        // When
        var result1 = formerTeammateCreator.createFormerTeammate(command1, context);
        var result2 = formerTeammateCreator.createFormerTeammate(command2, context);

        // Then
        assertThat(result1.id()).isNotEqualTo(result2.id());
    }

    // Helper methods
    private FormerTeammateRegistrationRequest createCommand(String firstName, String lastName, String phone, String email, LocalDate birthDate, List<Role> roles) {
        return new FormerTeammateRegistrationRequest(
                Gender.MALE,
                firstName,
                lastName,
                email,
                phone,
                birthDate,
                roles
        );
    }

    private ContextDetails createContextWithUser() {
        var currentUser = new CurrentUser("user-id-" + "testUser", "testUser", Set.of());
        return new ContextDetails(Optional.of(currentUser));
    }

    private ContextDetails createContextWithoutUser() {
        return new ContextDetails(Optional.empty());
    }

    private FormerTeammate createTestFormerTeammate(String firstName, String lastName) {
        return FormerTeammate.builder()
                .id(UUID.randomUUID())
                .gender(Gender.MALE)
                .firstName(firstName)
                .lastName(lastName)
                .status(ContactStatus.SUBMITTED)
                .build();
    }

    private FormerTeammate createTestFormerTeammateWithPhone(String phone) {
        return FormerTeammate.builder()
                .id(UUID.randomUUID())
                .gender(Gender.MALE)
                .firstName("Jane")
                .lastName("Smith")
                .phone(phone)
                .status(ContactStatus.SUBMITTED)
                .build();
    }

    static Stream<Arguments> provideGenderScenarios() {
        return Stream.of(
                Arguments.of(Gender.MALE, "Male gender"),
                Arguments.of(Gender.FEMALE, "Female gender")
        );
    }

    static Stream<Arguments> provideInvalidNameScenarios() {
        return Stream.of(
                Arguments.of("John", "Doe", true, "Exact same name should throw"),
                Arguments.of("john", "doe", false, "Different case should not throw"),
                Arguments.of("John", "Smith", false, "Different last name should not throw"),
                Arguments.of("Jane", "Doe", false, "Different first name should not throw"),
                Arguments.of("Johnny", "Doe", false, "Similar but different first name should not throw")
        );
    }
}