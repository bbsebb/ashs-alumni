package fr.hoenheimsports.app.controllers;

import fr.hoenheimsports.app.controllers.dtos.UserRegistrationRequest;
import fr.hoenheimsports.app.services.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final UserRegistrationService registrationService;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegistrationRequest userDto) {
        var _ = registrationService.registerUser(userDto);
        return ResponseEntity.ok("Utilisateur créé avec succès");
    }
}
