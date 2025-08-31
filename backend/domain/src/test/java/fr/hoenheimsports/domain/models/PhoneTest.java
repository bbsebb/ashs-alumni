package fr.hoenheimsports.domain.models;

import fr.hoenheimsports.domain.exceptions.InvalidPhoneNumberException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PhoneTest {

    @Test
    void should_create_phone_with_valid_international_format() {
        // Given
        String validPhoneNumber = "+33123456789";
        
        // When
        Phone phone = new Phone(validPhoneNumber);
        
        // Then
        assertThat(phone.value()).isEqualTo(validPhoneNumber);
    }

    @Test
    void should_normalize_phone_number_by_removing_spaces_and_dashes() {
        // Given
        String phoneWithSpaces = "+33 1 23 45 67 89";
        String phoneWithDashes = "+33-1-23-45-67-89";
        String expectedNormalized = "+33123456789";
        
        // When
        Phone phoneFromSpaces = new Phone(phoneWithSpaces);
        Phone phoneFromDashes = new Phone(phoneWithDashes);
        
        // Then
        assertThat(phoneFromSpaces.value()).isEqualTo(expectedNormalized);
        assertThat(phoneFromDashes.value()).isEqualTo(expectedNormalized);
    }

    @Test
    void should_throw_exception_when_phone_is_null() {
        // When & Then
        assertThatThrownBy(() -> new Phone(null))
                .isInstanceOf(InvalidPhoneNumberException.class)
                .hasMessage("Le numéro de téléphone ne peut pas être null ou vide");
    }

    @Test
    void should_throw_exception_when_phone_is_empty() {
        // When & Then
        assertThatThrownBy(() -> new Phone(""))
                .isInstanceOf(InvalidPhoneNumberException.class)
                .hasMessage("Le numéro de téléphone ne peut pas être null ou vide");
    }

    @Test
    void should_throw_exception_when_phone_is_blank() {
        // When & Then
        assertThatThrownBy(() -> new Phone("   "))
                .isInstanceOf(InvalidPhoneNumberException.class)
                .hasMessage("Le numéro de téléphone ne peut pas être null ou vide");
    }

    @Test
    void should_throw_exception_when_phone_does_not_start_with_plus() {
        // Given
        String invalidPhone = "33123456789";
        
        // When & Then
        assertThatThrownBy(() -> new Phone(invalidPhone))
                .isInstanceOf(InvalidPhoneNumberException.class)
                .hasMessageContaining("Le numéro de téléphone ne respecte pas le format E.164");
    }

    @Test
    void should_throw_exception_when_phone_is_too_long() {
        // Given - Phone with more than 15 digits (excluding +)
        String tooLongPhone = "+3312345678901234567";
        
        // When & Then
        assertThatThrownBy(() -> new Phone(tooLongPhone))
                .isInstanceOf(InvalidPhoneNumberException.class)
                .hasMessageContaining("Le numéro de téléphone ne respecte pas le format E.164");
    }

    @Test
    void should_return_phone_value_when_toString_called() {
        // Given
        String phoneNumber = "+33123456789";
        Phone phone = new Phone(phoneNumber);
        
        // When
        String result = phone.toString();
        
        // Then
        assertThat(result).isEqualTo(phoneNumber);
    }

    @Test
    void should_mask_phone_number_correctly_for_french_number() {
        // Given
        String phoneNumber = "+33638123456";
        Phone phone = new Phone(phoneNumber);
        
        // When
        String maskedPhone = phone.toMaskedFormat();
        
        // Then
        assertThat(maskedPhone).isEqualTo("+33******456");
    }

    @Test
    void should_mask_valid_short_phone_number() {
        // Given
        String shortPhone = "+3312345678";
        Phone phone = new Phone(shortPhone);
        
        // When
        String maskedPhone = phone.toMaskedFormat();
        
        // Then
        assertThat(maskedPhone).isEqualTo("+33*****678");
    }

    @Test
    void should_format_french_phone_for_display() {
        // Given
        String frenchPhone = "+33123456789";
        Phone phone = new Phone(frenchPhone);
        
        // When
        String displayFormat = phone.toDisplayFormat();
        
        // Then
        assertThat(displayFormat).isEqualTo("+33 1 23 45 67 89");
    }

    @Test
    void should_format_us_phone_for_display() {
        // Given
        String usPhone = "+12345678900";
        Phone phone = new Phone(usPhone);
        
        // When
        String displayFormat = phone.toDisplayFormat();
        
        // Then
        assertThat(displayFormat).isEqualTo("+1 234 567 8900");
    }

    @Test
    void should_format_generic_phone_for_display() {
        // Given
        String genericPhone = "+49123456789";
        Phone phone = new Phone(genericPhone);
        
        // When
        String displayFormat = phone.toDisplayFormat();
        
        // Then
        assertThat(displayFormat).isEqualTo("+491 234 567 89");
    }

    @Test
    void should_create_phone_using_of_static_method() {
        // Given
        String phoneNumber = "+33123456789";
        
        // When
        Phone phone = Phone.of(phoneNumber);
        
        // Then
        assertThat(phone.value()).isEqualTo(phoneNumber);
    }

    @Test
    void should_throw_exception_when_using_of_with_invalid_phone() {
        // Given
        String invalidPhone = "invalid";
        
        // When & Then
        assertThatThrownBy(() -> Phone.of(invalidPhone))
                .isInstanceOf(InvalidPhoneNumberException.class);
    }

    @Test
    void should_return_true_for_valid_phone_number() {
        // Given
        String validPhone = "+33123456789";
        
        // When
        boolean isValid = Phone.isValid(validPhone);
        
        // Then
        assertThat(isValid).isTrue();
    }

    @Test
    void should_return_false_for_invalid_phone_number() {
        // Given
        String invalidPhone = "invalid";
        
        // When
        boolean isValid = Phone.isValid(invalidPhone);
        
        // Then
        assertThat(isValid).isFalse();
    }

    @Test
    void should_return_false_for_null_phone_number() {
        // When
        boolean isValid = Phone.isValid(null);
        
        // Then
        assertThat(isValid).isFalse();
    }

    @Test
    void should_return_false_for_empty_phone_number() {
        // When
        boolean isValid = Phone.isValid("");
        
        // Then
        assertThat(isValid).isFalse();
    }

    @Test
    void should_be_equal_when_same_phone_value() {
        // Given
        String phoneNumber = "+33123456789";
        Phone phone1 = new Phone(phoneNumber);
        Phone phone2 = new Phone(phoneNumber);
        
        // Then
        assertThat(phone1).isEqualTo(phone2);
        assertThat(phone1.hashCode()).isEqualTo(phone2.hashCode());
    }

    @Test
    void should_not_be_equal_when_different_phone_values() {
        // Given
        Phone phone1 = new Phone("+33123456789");
        Phone phone2 = new Phone("+33987654321");
        
        // Then
        assertThat(phone1).isNotEqualTo(phone2);
    }
}