package com.mikhail.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class WebSecurity {

    public boolean authBelongsToUserId(Long requestedUserId) {

        if (requestedUserId == null) {
            return false;
        }

        CustomKeycloakAuthenticationToken token = getToken();
        Long actualUserId = token.getUserId();
        return Objects.equals(requestedUserId, actualUserId);
    }

    private CustomKeycloakAuthenticationToken getToken() {
        return (CustomKeycloakAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
    }

}
