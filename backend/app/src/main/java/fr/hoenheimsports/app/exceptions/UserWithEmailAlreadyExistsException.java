package fr.hoenheimsports.app.exceptions;

public class UserWithEmailAlreadyExistsException extends UserAlreadyExistsException {
    public UserWithEmailAlreadyExistsException(String message) {
        super(message);
    }
}
