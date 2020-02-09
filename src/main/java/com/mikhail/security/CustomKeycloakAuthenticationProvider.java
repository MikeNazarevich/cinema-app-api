package com.mikhail.security;


import com.mikhail.user.User;
import com.mikhail.user.UserService;
import lombok.RequiredArgsConstructor;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class CustomKeycloakAuthenticationProvider extends KeycloakAuthenticationProvider {

    private final UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) super.authenticate(authentication);

        KeycloakPrincipal keycloakPrincipal = (KeycloakPrincipal) authentication.getPrincipal();
        String iamId = keycloakPrincipal.getKeycloakSecurityContext().getToken().getSubject();

        User user = userService.findByIamId(iamId);

        // create user if user is null

        CustomKeycloakAuthenticationToken enrichedToken = new CustomKeycloakAuthenticationToken(
                token.getAccount(), token.isInteractive(), token.getAuthorities(), user.getId());

        return enrichedToken;
    }



}