package com.mikhail.security;

public interface CustomPermissionEvaluator {

    String getPermissionName();

    boolean hasPermission(CustomKeycloakAuthenticationToken principal, Object evaluationData);
}