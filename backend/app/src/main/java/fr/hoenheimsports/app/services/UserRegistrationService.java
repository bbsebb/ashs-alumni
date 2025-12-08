package fr.hoenheimsports.app.services;

import fr.hoenheimsports.app.controllers.dtos.UserRegistrationRequest;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserRegistrationService {

    private final Keycloak keycloak;
    @Value("${keycloak.realm}")
    private String realm;

    public String registerUser(UserRegistrationRequest userDto) {
        UserRepresentation user = new UserRepresentation();
        user.setEmail(userDto.email());
        user.setFirstName(userDto.firstName());
        user.setLastName(userDto.lastName());
        user.setEnabled(true);



        // Définition du mot de passe
        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(userDto.password());
        credential.setTemporary(false);
        user.setCredentials(Collections.singletonList(credential));

        // Appel à Keycloak pour créer l'utilisateur
        UsersResource usersResource = keycloak.realm(realm).users();
        try(Response response = usersResource.create(user)) {
            log.debug("User created: {}", response.toString());
            String userId = CreatedResponseUtil.getCreatedId(response);
            if (response.getStatus() != 201) {
                log.error(response.toString());
                throw new RuntimeException("Erreur lors de la création Keycloak: " + response.getStatus());
            }
            return userId;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
