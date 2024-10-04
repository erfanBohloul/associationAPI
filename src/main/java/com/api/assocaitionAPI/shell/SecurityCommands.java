package com.api.assocaitionAPI.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Iterator;

@ShellComponent
public class SecurityCommands {

    private final AuthenticationManager authenticationManager;

    public SecurityCommands(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @ShellMethod(key = "login", value = "Login to the system")
    public String login(@ShellOption(value = "-u", help = "Username") String username,
                        @ShellOption(value = "-p", help = "Password") String password) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Retrieve the User object from the database
            Object principal = authentication.getPrincipal();

            if (principal != null) {
                User user = (User) principal;
                return "Login successful as " + user.getUsername();
            } else {
                return "Invalid username or password.";
            }
        } catch (BadCredentialsException e) {
            return "Invalid username or password.";
        }
    }

    @ShellMethod(key = "logout", value = "Logout from the system")
    public String logout() {
        SecurityContextHolder.clearContext();
        return "Logout successful!";
    }

    @ShellMethod(key = "whoami", value = "Display logged-in user")
    public String whoami() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return "Logged in as: " + authentication.getName();
        } else {
            return "Not logged in.";
        }
    }


    @ShellMethod(key = "whatrole", value = "Shows the role of user")
    public String whatrole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        if (authentication != null && authentication.isAuthenticated()) {
            Iterator<?> authority = authentication.getAuthorities().iterator();

            if (authority.hasNext()) {
                return "your role: " + authority.next();
            }
            else {
                return "no role.";
            }
//            return "your role: " + authentication.getAuthorities().iterator().next().getAuthority();
        }
        return "Not logged in.";
    }

}
