package fr.hoenheimsports.domain.services.validations;

import fr.hoenheimsports.domain.exceptions.InvalidPhoneNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PhoneValidationServiceTest {

    private PhoneValidationService phoneValidationService;

    @BeforeEach
    void setUp() {
        phoneValidationService = new PhoneValidationService();
    }

    // Tests for normalize method
    @Test
    void should_normalize_phone_by_removing_spaces() {
        // Given
        String phoneWithSpaces = "+33 1 23 45 67 89";
        
        // When
        String normalized = phoneValidationService.normalize(phoneWithSpaces);
        
        // Then
        assertThat(normalized).isEqualTo("+33123456789");
    }

    @Test
    void should_normalize_phone_by_removing_dashes() {
        // Given
        String phoneWithDashes = "+33-1-23-45-67-89";
        
        // When
        String normalized = phoneValidationService.normalize(phoneWithDashes);
        
        // Then
        assertThat(normalized).isEqualTo("+33123456789");
    }

    @Test
    void should_normalize_phone_by_removing_mixed_spaces_and_dashes() {
        // Given
        String phoneWithMixedSeparators = "+33 1-23 45-67 89";
        
        // When
        String normalized = phoneValidationService.normalize(phoneWithMixedSeparators);
        
        // Then
        assertThat(normalized).isEqualTo("+33123456789");
    }

    @Test
    void should_return_null_when_normalizing_null_phone() {
        // When
        String normalized = phoneValidationService.normalize(null);
        
        // Then
        assertThat(normalized).isNull();
    }

    @Test
    void should_return_same_phone_when_already_normalized() {
        // Given
        String alreadyNormalized = "+33123456789";
        
        // When
        String normalized = phoneValidationService.normalize(alreadyNormalized);
        
        // Then
        assertThat(normalized).isEqualTo(alreadyNormalized);
    }

    // Tests for isValid method
    @Test
    void should_return_true_for_valid_french_phone() {
        // Given
        String validFrenchPhone = "+33123456789";
        
        // When
        boolean isValid = phoneValidationService.isValid(validFrenchPhone);
        
        // Then
        assertThat(isValid).isTrue();
    }

    @Test
    void should_return_true_for_valid_us_phone() {
        // Given
        String validUsPhone = "+12345678900";
        
        // When
        boolean isValid = phoneValidationService.isValid(validUsPhone);
        
        // Then
        assertThat(isValid).isTrue();
    }

    @Test
    void should_return_true_for_valid_phone_with_spaces() {
        // Given
        String validPhoneWithSpaces = "+33 1 23 45 67 89";
        
        // When
        boolean isValid = phoneValidationService.isValid(validPhoneWithSpaces);
        
        // Then
        assertThat(isValid).isTrue();
    }

    @Test
    void should_return_true_for_valid_phone_with_dashes() {
        // Given
        String validPhoneWithDashes = "+33-1-23-45-67-89";
        
        // When
        boolean isValid = phoneValidationService.isValid(validPhoneWithDashes);
        
        // Then
        assertThat(isValid).isTrue();
    }

    @Test
    void should_return_false_for_null_phone() {
        // When
        boolean isValid = phoneValidationService.isValid(null);
        
        // Then
        assertThat(isValid).isFalse();
    }

    @Test
    void should_return_false_for_empty_phone() {
        // When
        boolean isValid = phoneValidationService.isValid("");
        
        // Then
        assertThat(isValid).isFalse();
    }

    @Test
    void should_return_false_for_blank_phone() {
        // When
        boolean isValid = phoneValidationService.isValid("   ");
        
        // Then
        assertThat(isValid).isFalse();
    }

    @Test
    void should_return_false_for_phone_without_plus_prefix() {
        // Given
        String phoneWithoutPlus = "33123456789";
        
        // When
        boolean isValid = phoneValidationService.isValid(phoneWithoutPlus);
        
        // Then
        assertThat(isValid).isFalse();
    }

    @Test
    void should_return_false_for_phone_starting_with_zero_country_code() {
        // Given
        String phoneWithZeroCountryCode = "+0123456789";
        
        // When
        boolean isValid = phoneValidationService.isValid(phoneWithZeroCountryCode);
        
        // Then
        assertThat(isValid).isFalse();
    }

    @Test
    void should_return_false_for_phone_too_long() {
        // Given - Phone with more than 15 digits (excluding +)
        String tooLongPhone = "+3312345678901234567";
        
        // When
        boolean isValid = phoneValidationService.isValid(tooLongPhone);
        
        // Then
        assertThat(isValid).isFalse();
    }

    @Test
    void should_return_false_for_phone_too_short() {
        // Given
        String tooShortPhone = "+33123";
        
        // When
        boolean isValid = phoneValidationService.isValid(tooShortPhone);
        
        // Then
        assertThat(isValid).isFalse();
    }

    @Test
    void should_return_false_for_phone_with_letters() {
        // Given
        String phoneWithLetters = "+33abc456789";
        
        // When
        boolean isValid = phoneValidationService.isValid(phoneWithLetters);
        
        // Then
        assertThat(isValid).isFalse();
    }

    @Test
    void should_return_false_for_phone_with_special_characters() {
        // Given
        String phoneWithSpecialChars = "+33#123*456789";
        
        // When
        boolean isValid = phoneValidationService.isValid(phoneWithSpecialChars);
        
        // Then
        assertThat(isValid).isFalse();
    }

    // Tests for validateAndNormalize method
    @Test
    void should_validate_and_normalize_valid_phone() {
        // Given
        String validPhone = "+33 1 23 45 67 89";
        String expectedNormalized = "+33123456789";
        
        // When
        String result = phoneValidationService.validateAndNormalize(validPhone);
        
        // Then
        assertThat(result).isEqualTo(expectedNormalized);
    }

    @Test
    void should_validate_and_normalize_valid_phone_with_dashes() {
        // Given
        String validPhoneWithDashes = "+33-1-23-45-67-89";
        String expectedNormalized = "+33123456789";
        
        // When
        String result = phoneValidationService.validateAndNormalize(validPhoneWithDashes);
        
        // Then
        assertThat(result).isEqualTo(expectedNormalized);
    }

    @Test
    void should_throw_exception_when_validating_null_phone() {
        // When & Then
        assertThatThrownBy(() -> phoneValidationService.validateAndNormalize(null))
                .isInstanceOf(InvalidPhoneNumberException.class)
                .hasMessage("Le numéro de téléphone ne peut pas être null ou vide");
    }

    @Test
    void should_throw_exception_when_validating_empty_phone() {
        // When & Then
        assertThatThrownBy(() -> phoneValidationService.validateAndNormalize(""))
                .isInstanceOf(InvalidPhoneNumberException.class)
                .hasMessage("Le numéro de téléphone ne peut pas être null ou vide");
    }

    @Test
    void should_throw_exception_when_validating_blank_phone() {
        // When & Then
        assertThatThrownBy(() -> phoneValidationService.validateAndNormalize("   "))
                .isInstanceOf(InvalidPhoneNumberException.class)
                .hasMessage("Le numéro de téléphone ne peut pas être null ou vide");
    }

    @Test
    void should_throw_exception_when_phone_does_not_match_e164_format() {
        // Given
        String invalidPhone = "33123456789";
        
        // When & Then
        assertThatThrownBy(() -> phoneValidationService.validateAndNormalize(invalidPhone))
                .isInstanceOf(InvalidPhoneNumberException.class)
                .hasMessageContaining("Le numéro de téléphone ne respecte pas le format E.164")
                .hasMessageContaining("Format reçu après normalisation: " + invalidPhone);
    }

    @Test
    void should_throw_exception_when_phone_starts_with_zero_country_code() {
        // Given
        String phoneWithZeroCountryCode = "+0123456789";
        
        // When & Then
        assertThatThrownBy(() -> phoneValidationService.validateAndNormalize(phoneWithZeroCountryCode))
                .isInstanceOf(InvalidPhoneNumberException.class)
                .hasMessageContaining("Le numéro de téléphone ne respecte pas le format E.164");
    }

    @Test
    void should_throw_exception_when_phone_is_too_long() {
        // Given - Phone with more than 15 digits (excluding +)
        String tooLongPhone = "+3312345678901234567";
        
        // When & Then
        assertThatThrownBy(() -> phoneValidationService.validateAndNormalize(tooLongPhone))
                .isInstanceOf(InvalidPhoneNumberException.class)
                .hasMessageContaining("Le numéro de téléphone ne respecte pas le format E.164")
                .hasMessageContaining("Format reçu après normalisation: " + tooLongPhone);
    }

    @Test
    void should_throw_exception_when_phone_contains_letters() {
        // Given
        String phoneWithLetters = "+33abc456789";
        
        // When & Then
        assertThatThrownBy(() -> phoneValidationService.validateAndNormalize(phoneWithLetters))
                .isInstanceOf(InvalidPhoneNumberException.class)
                .hasMessageContaining("Le numéro de téléphone ne respecte pas le format E.164");
    }

    @Test
    void should_accept_minimum_length_phone() {
        // Given - Minimum valid phone (country code + 4 digits)
        String minimumPhone = "+1123456789";
        
        // When
        String result = phoneValidationService.validateAndNormalize(minimumPhone);
        
        // Then
        assertThat(result).isEqualTo(minimumPhone);
    }

    @Test
    void should_accept_maximum_length_phone() {
        // Given - Maximum valid phone (15 digits total excluding +)
        String maximumPhone = "+123456789012345";
        
        // When
        String result = phoneValidationService.validateAndNormalize(maximumPhone);
        
        // Then
        assertThat(result).isEqualTo(maximumPhone);
    }

    @Test
    void should_handle_various_country_codes() {
        // Given
        String[] validPhones = {
            "+33123456789",  // France
            "+12345678900",  // US/Canada
            "+4912345678",   // Germany
            "+8612345678901", // China
            "+919876543210"  // India
        };
        
        // When & Then
        for (String phone : validPhones) {
            assertThatCode(() -> phoneValidationService.validateAndNormalize(phone))
                    .doesNotThrowAnyException();
            assertThat(phoneValidationService.isValid(phone)).isTrue();
        }
    }
}