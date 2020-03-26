package com.mikhail.security;


import com.mikhail.user.User;
import com.mikhail.user.UserService;
import lombok.RequiredArgsConstructor;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@RequiredArgsConstructor
public class CustomKeycloakAuthenticationProvider extends KeycloakAuthenticationProvider {

    private final UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) super.authenticate(authentication);

        KeycloakPrincipal keycloakPrincipal = (KeycloakPrincipal) authentication.getPrincipal();
        AccessToken accessToken = keycloakPrincipal.getKeycloakSecurityContext().getToken();
        String iamId = accessToken.getSubject();

        Optional<User> user = Optional.ofNullable(userService.findByIamId(iamId)
                .orElseGet(() -> userService.saveUser(createNewUser(accessToken))));

        return new CustomKeycloakAuthenticationToken(
                token.getAccount(), token.isInteractive(), token.getAuthorities(), user.get().getId());
    }

    public static String getCurrentUserLogin() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    private User createNewUser(AccessToken accessToken) {
        return User.builder()
                .iamId(accessToken.getSubject())
                .email(accessToken.getEmail())
                .name(accessToken.getGivenName())
                .surname(accessToken.getFamilyName())
                .username(accessToken.getPreferredUsername())
                .build();
    }

}