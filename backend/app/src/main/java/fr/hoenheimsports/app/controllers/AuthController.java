package fr.hoenheimsports.app.controllers;

import fr.hoenheimsports.app.controllers.dtos.UserRegistrationRequest;
import fr.hoenheimsports.app.services.KeycloakAuthService;
import fr.hoenheimsports.domain.api.BindUserId;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final KeycloakAuthService keycloakAuthService;
    private final BindUserId keycloakUserIdBinder;
    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid UserRegistrationRequest userDto) {
        log.debug("Registering user {}", userDto);
        var rtr = keycloakAuthService.registerUser(userDto.email(), userDto.password(), userDto.firstName(), userDto.lastName());
        var formerTeammate = this.keycloakUserIdBinder.bind(rtr, userDto.formerTeammateId());
        log.debug("User {} registered", formerTeammate);
        return ResponseEntity.noContent().build();
    }


}
