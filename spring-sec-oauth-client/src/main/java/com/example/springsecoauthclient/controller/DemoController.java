package com.example.springsecoauthclient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequiredArgsConstructor
public class DemoController {

    private final OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager;

    @GetMapping("/token")
    public String getToken() {

        OAuth2AuthorizeRequest oAuth2AuthorizeRequest = OAuth2AuthorizeRequest.withClientRegistrationId("1")
                .principal("client")
                .build();

        OAuth2AuthorizedClient authorize = oAuth2AuthorizedClientManager.authorize(oAuth2AuthorizeRequest);

        return authorize.getAccessToken().getTokenValue();

    }
}
