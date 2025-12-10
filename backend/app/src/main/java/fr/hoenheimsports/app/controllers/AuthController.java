package fr.hoenheimsports.app.controllers;

import fr.hoenheimsports.app.controllers.dtos.UserRegistrationRequest;
import fr.hoenheimsports.app.services.KeycloakAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration")
@RequiredArgsConstructor
public class AuthController {
    private final KeycloakAuthService keycloakAuthService;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegistrationRequest userDto) {
        var _ = keycloakAuthService.registerUser(userDto.email(), userDto.password(), userDto.firstName(), userDto.lastName());
        return ResponseEntity.ok("Utilisateur créé avec succès");
    }


}
