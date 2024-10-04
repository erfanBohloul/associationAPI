package com.api.assocaitionAPI.service.security;

import com.api.assocaitionAPI.model.account.Admin;
import com.api.assocaitionAPI.repo.AdminRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AdminRepo adminRepo;

    public UserDetailsServiceImpl(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepo.findByUsername(username);

        System.out.println("admin loaded: " + admin);
        if (admin == null) {
            throw new UsernameNotFoundException("User not found");
        }

        Collection<GrantedAuthority> grantedAuthorities = admin.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                admin.getUsername(),
                admin.getPassword(),
                grantedAuthorities
        );
    }
}
