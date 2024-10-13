package com.api.assocaitionAPI.service.security.permission_eval;

import com.api.assocaitionAPI.model.account.GrantedAuthority;
import com.api.assocaitionAPI.model.account.user.User;
import com.api.assocaitionAPI.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Set;

@Component
public class PermissionEval implements PermissionEvaluator {

    @Autowired
    private UserRepo userRepo;

    @Override
    public boolean hasPermission(
            Authentication authentication,
            Object targetDomainObject,
            Object permission) {

        System.out.println(targetDomainObject);
        System.out.println(targetDomainObject.getClass());
        System.out.println("permission: " + permission);
        System.out.println("name: " + authentication.getName());

        User user = userRepo.findByUsername(authentication.getName());
        System.out.println("user: " + user);


        Set<GrantedAuthority> grantedAuthorities = user.getAuthorities();
        try {
            // some reflective work to get the ID in question
            Class<?> targetType = targetDomainObject.getClass();
            Method method = targetType.getMethod("getId");
            Long id = (Long) method.invoke(targetDomainObject);

            System.out.println("id: " + id);

            // compile grantedAuthorityString
            String grantedAuthorityString = id + "_" +
                    targetType.getName() + "_" + permission;

            System.out.println("grantedAuthorityString" + grantedAuthorityString);

            // check if user has matching authority and
            // return true if so, false otherwise
            for (GrantedAuthority ga : grantedAuthorities) {
                System.out.println(ga.getAuthority());
                if (ga.getAuthority()
                        .equalsIgnoreCase(grantedAuthorityString)) {
                    return true;
                }
            }
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean hasPermission(
            Authentication authentication,
            Serializable targetId,
            String targetType,
            Object permission) {

        User user = userRepo.findByUsername(authentication.getName());
        Set<GrantedAuthority> grantedAuthorities = user.getAuthorities();

        try {
            // compile grantedAuthorityString
            String grantedAuthorityString = targetId + "_"
                    + targetType + "_" + permission;

            // check if user has matching authority.
            // return true if so false otherwise
            for (GrantedAuthority ga : grantedAuthorities) {
                if (ga.getAuthority()
                        .equalsIgnoreCase(grantedAuthorityString)) {
                    return true;
                }
            }
            return false;

        } catch (Exception e) {
            return false;
        }
    }

}
