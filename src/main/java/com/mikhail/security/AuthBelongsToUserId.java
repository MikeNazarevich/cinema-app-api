package com.mikhail.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class AuthBelongsToUserId implements CustomPermissionEvaluator {

    @Override
    public String getPermissionName() {
        return "authBelongsToUserId";
    }

    @Override
    public boolean hasPermission(CustomKeycloakAuthenticationToken principal, Object evaluationData) {
        Long expectedUserId = (Long) evaluationData;
        Long actualUserId = principal.getUserId();
        return Objects.equals(expectedUserId, actualUserId);
    }
}