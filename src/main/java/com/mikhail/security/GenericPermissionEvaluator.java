package com.mikhail.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class GenericPermissionEvaluator implements PermissionEvaluator {

    private final List<CustomPermissionEvaluator> evaluators;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        boolean result = false;
        if (authentication != null) {
            result = evaluatePermission(targetDomainObject, permission, (CustomKeycloakAuthenticationToken)authentication);
        }
        return result;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }

    private Boolean evaluatePermission(Object targetDomainObject, Object permission, CustomKeycloakAuthenticationToken authentication) {
        return evaluators.stream()
                .filter(e -> Objects.equals(e.getPermissionName(), permission))
                .findFirst()
                .map(e -> e.hasPermission(authentication, targetDomainObject))
                .orElse(false);
    }
}