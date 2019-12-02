package com.mikhail.audit;

import com.mikhail.security.WebSecurity;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String id = WebSecurity.getToken().getUserId().toString();
        return id != null ? Optional.of(id) : Optional.of("system");
    }
}
