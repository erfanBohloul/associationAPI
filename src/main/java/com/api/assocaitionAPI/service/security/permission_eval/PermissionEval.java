package com.api.assocaitionAPI.service.security.permission_eval;

import org.springframework.security.core.Authentication;

public interface PermissionEval {

    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission);

}
