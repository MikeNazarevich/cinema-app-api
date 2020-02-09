package com.mikhail.config;

import com.mikhail.security.GenericPermissionEvaluator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
class MethodSecurityConfiguration extends GlobalMethodSecurityConfiguration {

    private final ApplicationContext context;
    private final GenericPermissionEvaluator genericPermissionEvaluator;

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        DefaultMethodSecurityExpressionHandler handler = new DefaultMethodSecurityExpressionHandler();
        handler.setPermissionEvaluator(genericPermissionEvaluator);
        handler.setApplicationContext(context);
        handler.setDefaultRolePrefix("");
        return handler;
    }
}