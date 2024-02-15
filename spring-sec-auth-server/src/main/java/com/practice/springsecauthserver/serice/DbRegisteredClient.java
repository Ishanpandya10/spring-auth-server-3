package com.practice.springsecauthserver.serice;

import com.practice.springsecauthserver.model.AuthClient;
import com.practice.springsecauthserver.repository.AuthClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbRegisteredClient implements RegisteredClientRepository {
    private final AuthClientRepository clientRepository;

    @Override
    public void save(RegisteredClient registeredClient) {
        AuthClient authClient = AuthClient.from(registeredClient);
        clientRepository.save(authClient);
    }

    @Override
    public RegisteredClient findById(String id) {
        Optional<AuthClient> byId = clientRepository.findById(Integer.valueOf(id));
        return AuthClient.from(byId.orElseThrow());
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        Optional<AuthClient> byId = clientRepository.findByClientId(clientId);
        return AuthClient.from(byId.orElseThrow());
    }
}
