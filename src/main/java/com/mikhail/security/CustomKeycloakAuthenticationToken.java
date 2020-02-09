package com.mikhail.security;

import lombok.Getter;
import org.keycloak.adapters.spi.KeycloakAccount;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
public class CustomKeycloakAuthenticationToken extends KeycloakAuthenticationToken  {

    private final Long userId;

    public CustomKeycloakAuthenticationToken(KeycloakAccount account,
                                             boolean interactive,
                                             Collection<? extends GrantedAuthority> authorities,
                                             Long userId) {
        super(account, interactive, authorities);
        this.userId = userId;
    }

}