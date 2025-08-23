package fr.hoenheimsports.user.domain.models;

import java.util.Locale;

public enum Role {
    USER, ADMIN;

    public static Role from(String value) {
        if (value == null) {
            throw new IllegalArgumentException("role cannot be null");
        }
        try {
            return Role.valueOf(value.trim().toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Unknown role: " + value);
        }
    }

}
