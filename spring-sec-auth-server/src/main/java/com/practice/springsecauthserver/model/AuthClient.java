package com.practice.springsecauthserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

@Entity(name = "clients")
@Getter
@Setter
public class AuthClient {

    @Id
    private int id;

    private String clientId;
    private String clientSecret;
    private String authMethod;
    private String grantType;
    private String redirectUri;
    private String scope;

    public static RegisteredClient from(AuthClient authClient) {
        return RegisteredClient
                .withId(String.valueOf(authClient.getId()))
                .clientId(authClient.getClientId())
                .clientSecret(authClient.getClientSecret())
                .clientAuthenticationMethod(new ClientAuthenticationMethod(authClient.getAuthMethod()))
                .authorizationGrantType(new AuthorizationGrantType(authClient.getGrantType()))
                .redirectUri(authClient.getRedirectUri())
                .scope(authClient.getScope())
                .build();
    }

    public static AuthClient from(RegisteredClient registeredClient) {
        AuthClient authClient = new AuthClient();
        authClient.setClientId(registeredClient.getClientId());
        authClient.setClientSecret(registeredClient.getClientSecret());
        authClient.setAuthMethod(registeredClient.getClientAuthenticationMethods().stream().findAny().orElseThrow().getValue());
        authClient.setGrantType(registeredClient.getAuthorizationGrantTypes().stream().findAny().orElseThrow().getValue());
        authClient.setRedirectUri(registeredClient.getRedirectUris().stream().findAny().orElseThrow());
        authClient.setScope(registeredClient.getScopes().stream().findAny().orElseThrow());
        return authClient;
    }


}
