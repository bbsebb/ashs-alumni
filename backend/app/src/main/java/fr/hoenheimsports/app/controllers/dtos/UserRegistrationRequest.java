package fr.hoenheimsports.app.controllers.dtos;

public record UserRegistrationRequest(String email, String lastName,String firstName,String password) {
}
