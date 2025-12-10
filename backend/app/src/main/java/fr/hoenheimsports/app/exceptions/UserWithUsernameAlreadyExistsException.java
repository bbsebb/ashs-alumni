package fr.hoenheimsports.app.exceptions;

public class UserWithUsernameAlreadyExistsException extends UserAlreadyExistsException {
    public UserWithUsernameAlreadyExistsException(String message) {
        super(message);
    }
}
