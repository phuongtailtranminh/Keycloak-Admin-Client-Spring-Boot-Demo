package me.phuongtm;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by phuongtran on 6/6/17.
 */
@Service
public class KeycloakService {

    @Value("${keycloak.serverUrl}")
    private String SERVER_URL;

    @Value("${keycloak.realm}")
    private String REALM;

    @Value("${keycloak.username}")
    private String USERNAME;

    @Value("${keycloak.password}")
    private String PASSWORD;

    @Value("${keycloak.clientId}")
    private String CLIENT_ID;

    private Keycloak getInstance() {
        return KeycloakBuilder
                .builder()
                .serverUrl(SERVER_URL)
                .realm(REALM)
                .username(USERNAME)
                .password(PASSWORD)
                .clientId(CLIENT_ID)
                .build();
    }

    public void createAccount(final String username, final String password) {
        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(password);
        UserRepresentation user = new UserRepresentation();
        user.setUsername(username);
        user.setFirstName("First Name");
        user.setLastName("Last Name");
        user.setCredentials(Arrays.asList(credential));
        getInstance().realm(REALM).users().create(user);
    }

}
