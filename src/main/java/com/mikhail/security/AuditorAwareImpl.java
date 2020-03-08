package com.mikhail.security;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String username = CustomKeycloakAuthenticationProvider.getCurrentUserLogin();
        return username != null ? Optional.of(username) : Optional.empty();
    }
}
