package fr.hoenheimsports.app.services;

import fr.hoenheimsports.app.exceptions.AuthException;
import fr.hoenheimsports.app.exceptions.UserWithEmailAlreadyExistsException;
import fr.hoenheimsports.app.exceptions.UserWithUsernameAlreadyExistsException;
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

import javax.naming.AuthenticationException;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class KeycloakAuthService {

    private final Keycloak keycloak;
    @Value("${keycloak.realm}")
    private String realm;
    @Value("${app.frontend.redirect-url:http://localhost:4200/event-registration}")
    private String redirectUri;
    @Value("${keycloak.frontend-client-id}")
    private String clientId;
/*    @Value("${keycloak.client-id}")
    private String clientId;
    @Value("${keycloak.auth-server-url}")
    private String serverUrl;
    @Value("${keycloak.credentials.secret}")
    private String clientSecret;*/

    public String registerUser(String email, String password,String firstName,String lastName) {
        UserRepresentation user = new UserRepresentation();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEnabled(true);
        user.setEmailVerified(false); // L'email n'est pas encore vérifié
        user.setRequiredActions(Collections.singletonList("VERIFY_EMAIL"));


        // Définition du mot de passe
        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(password);
        credential.setTemporary(false);
        user.setCredentials(Collections.singletonList(credential));

        // Appel à Keycloak pour créer l'utilisateur
        UsersResource usersResource = keycloak.realm(realm).users();
        try(Response response = usersResource.create(user)) {
            log.debug("Response Status: {}", response.getStatus());

            if (response.getStatus() == 201) {
                String userId = CreatedResponseUtil.getCreatedId(response);
                log.debug("User created with ID: {}", userId);
                sendVerificationEmail(usersResource, userId);
                return userId;
            } else if (response.getStatus() == 409) {
                String errorBody = response.readEntity(String.class);
                log.error("Conflit Keycloak (409): {}", errorBody);

                if (errorBody.contains("email")) {
                    throw new UserWithEmailAlreadyExistsException("Un utilisateur avec cet email existe déjà.");
                } else if (errorBody.contains("username")) {
                    throw new UserWithUsernameAlreadyExistsException("Ce nom d'utilisateur est déjà pris.");
                } else {
                    throw new AuthException("L'utilisateur existe déjà (Conflit non spécifié).");
                }
            } else {
                log.error("Erreur Keycloak inconnue. Status: {} - Body: {}", response.getStatus(), response.readEntity(String.class));
                throw new AuthenticationException("Erreur lors de la création Keycloak: " + response.getStatus());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void sendVerificationEmail(UsersResource usersResource, String userId) {
        try {
            // Cette méthode envoie l'email 'VERIFY_EMAIL'.
            // Le 2ème paramètre est le Client ID (pour que Keycloak sache à qui appartient la redirection)
            // Le 3ème paramètre est l'URL de redirection après le clic dans l'email
            usersResource.get(userId).executeActionsEmail(
                    clientId,
                    redirectUri,
                    List.of("VERIFY_EMAIL")
            );
            log.info("Email de vérification envoyé pour l'utilisateur ID: {}", userId);
        } catch (Exception e) {
            log.error("Erreur lors de l'envoi de l'email de vérification", e);
            // On ne bloque pas forcément l'inscription si l'envoi d'email échoue,
            // mais c'est à vous de décider de la politique à adopter.
        }
    }

/*    // 1. LOGIN : Récupérer le Token via RestClient (API Token Keycloak)
    public Map<String, Object> login(String username, String password) {
        RestClient restClient = RestClient.create();

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", clientId);
        formData.add("client_secret", clientSecret);
        formData.add("username", username);
        formData.add("password", password);
        formData.add("grant_type", "password"); // Flow : Resource Owner Password

        String tokenEndpoint = serverUrl + "/realms/" + realm + "/protocol/openid-connect/token";

        return restClient.post()
                .uri(tokenEndpoint)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(formData)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    if (response.getStatusCode().value() == 401) {
                        throw new AuthException("Identifiants incorrects (Nom d'utilisateur ou mot de passe invalide).");
                    }
                    if (response.getStatusCode().value() == 400) {
                        // Keycloak renvoie 400 pour "Account disabled", "Account not verified", etc.
                        throw new AuthException("Compte désactivé ou requête invalide.");
                    }
                    throw new AuthException("Erreur d'authentification Keycloak : " + response.getStatusCode());
                })
                .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
                    throw new AuthException("Le serveur d'authentification est indisponible temporairement.");
                })
                .body(new ParameterizedTypeReference<Map<String, Object>>() {});
    }*/

}
