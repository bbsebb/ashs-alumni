package fr.hoenheimsports.domain.services.validations;

import fr.hoenheimsports.domain.exceptions.MissingRequiredFieldException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FieldValidationServiceTest {

    private FieldValidationService validationService;

    @BeforeEach
    void setUp() {
        validationService = new FieldValidationService();
    }

    // Tests for validateRequiredField(Object, String)
    @Test
    void testValidateRequiredField_WithValidObject_ShouldNotThrow() {
        // Given
        Object validObject = "test";
        String fieldName = "testField";

        // When & Then
        assertDoesNotThrow(() -> validationService.validateRequiredField(validObject, fieldName));
    }

    @Test
    void testValidateRequiredField_WithNullObject_ShouldThrowException() {
        // Given
        Object nullObject = null;
        String fieldName = "testField";

        // When & Then
        MissingRequiredFieldException exception = assertThrows(
                MissingRequiredFieldException.class,
                () -> validationService.validateRequiredField(nullObject, fieldName)
        );
        
        assertTrue(exception.getMessage().contains(fieldName));
    }

    @ParameterizedTest
    @MethodSource("validObjectData")
    void testValidateRequiredField_WithVariousValidObjects_ShouldNotThrow(String testCase, Object validObject) {
        // When & Then
        assertDoesNotThrow(() -> validationService.validateRequiredField(validObject, "field"),
                "Failed for test case: " + testCase);
    }

    static Stream<Arguments> validObjectData() {
        return Stream.of(
                arguments("String object", "string"),
                arguments("Integer object", 123),
                arguments("Boolean object", true),
                arguments("Double object", 3.14)
        );
    }

    @Test
    void testValidateRequiredField_WithUUID_ShouldNotThrow() {
        // Given
        UUID validUuid = UUID.randomUUID();
        
        // When & Then
        assertDoesNotThrow(() -> validationService.validateRequiredField(validUuid, "id"));
    }

    // Tests for validateRequiredStringField(String, String)
    @ParameterizedTest
    @MethodSource("validStringFieldData")
    void testValidateRequiredStringField_WithValidStrings_ShouldNotThrow(String testCase, String value) {
        // When & Then
        assertDoesNotThrow(() -> validationService.validateRequiredStringField(value, "field"),
                "Failed for test case: " + testCase);
    }

    static Stream<Arguments> validStringFieldData() {
        return Stream.of(
                arguments("Normal string", "John"),
                arguments("String with spaces", "John Doe"),
                arguments("String with leading/trailing spaces", "  John  "),
                arguments("Single character", "A"),
                arguments("String with special characters", "Jean-Pierre"),
                arguments("String with numbers", "User123")
        );
    }

    @ParameterizedTest
    @MethodSource("invalidStringFieldData")
    void testValidateRequiredStringField_WithInvalidStrings_ShouldThrowException(String testCase, String value) {
        // When & Then
        MissingRequiredFieldException exception = assertThrows(
                MissingRequiredFieldException.class,
                () -> validationService.validateRequiredStringField(value, "testField"),
                "Should have thrown exception for test case: " + testCase
        );
        
        assertTrue(exception.getMessage().contains("testField"));
    }

    static Stream<Arguments> invalidStringFieldData() {
        return Stream.of(
                arguments("Null string", null),
                arguments("Empty string", ""),
                arguments("String with only spaces", "   "),
                arguments("String with only tabs", "\t\t"),
                arguments("String with mixed whitespace", " \t \n ")
        );
    }

    // Tests for validateListField(List<T>)
    @Test
    void testValidateListField_WithValidList_ShouldReturnSameList() {
        // Given
        List<String> validList = List.of("item1", "item2");

        // When
        List<String> result = validationService.validateListField(validList);

        // Then
        assertSame(validList, result);
        assertEquals(2, result.size());
        assertEquals("item1", result.get(0));
        assertEquals("item2", result.get(1));
    }

    @Test
    void testValidateListField_WithEmptyList_ShouldReturnSameList() {
        // Given
        List<String> emptyList = List.of();

        // When
        List<String> result = validationService.validateListField(emptyList);

        // Then
        assertSame(emptyList, result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testValidateListField_WithNullList_ShouldReturnEmptyList() {
        // Given
        List<String> nullList = null;

        // When
        List<String> result = validationService.validateListField(nullList);

        // Then
        assertNotNull(result);
        assertTrue(result.isEmpty());
        assertEquals(List.of(), result);
    }

    @Test
    void testValidateListField_WithMutableList_ShouldReturnSameList() {
        // Given
        List<Integer> mutableList = new ArrayList<>();
        mutableList.add(1);
        mutableList.add(2);

        // When
        List<Integer> result = validationService.validateListField(mutableList);

        // Then
        assertSame(mutableList, result);
        assertEquals(2, result.size());
    }

    @Test
    void testValidateListField_GenericTypes_ShouldWork() {
        // Given
        List<UUID> uuidList = List.of(UUID.randomUUID(), UUID.randomUUID());

        // When
        List<UUID> result = validationService.validateListField(uuidList);

        // Then
        assertSame(uuidList, result);
        assertEquals(2, result.size());
    }

    // Integration tests
    @Test
    void testMultipleValidations_ShouldAllWork() {
        // Given
        String validString = "John";
        UUID validUuid = UUID.randomUUID();
        List<String> validList = List.of("role1");

        // When & Then - All should pass without throwing exceptions
        assertDoesNotThrow(() -> {
            validationService.validateRequiredField(validUuid, "id");
            validationService.validateRequiredStringField(validString, "name");
            List<String> resultList = validationService.validateListField(validList);
            assertEquals(validList, resultList);
        });
    }

    @Test
    void testValidationService_IsNotNull() {
        // Then
        assertNotNull(validationService);
    }
}