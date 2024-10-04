package com.api.assocaitionAPI.service.security.permission_eval;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class PermissionEvalImpl implements PermissionEval {
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        // TODO define hasPermission method
        return false;
    }

    private boolean ifUserAdmin(Authentication authentication) {
        return authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
    }
}
