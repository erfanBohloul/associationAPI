package com.api.assocaitionAPI.shell;

import com.api.assocaitionAPI.model.account.Role;
import com.api.assocaitionAPI.model.account.user.Writer;
import com.api.assocaitionAPI.repo.RoleRepo;
import com.api.assocaitionAPI.service.model.WriterService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class AdminCommands {

    private final WriterService writerService;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    public AdminCommands(WriterService writerService, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
        this.writerService = writerService;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ShellMethod(key = "create-writer", value = "Creates a Writer")
    public String createWrite(@ShellOption(value = "-u", help = "username") String username,
                              @ShellOption(value = "-p", help = "password") String password) {

        Writer writer = new Writer();
        writer.setUsername(username);
        writer.setPassword(passwordEncoder.encode(password));

        Role writerRole = roleRepo.findByName("WRITER");
        writer.getRoles().add(writerRole);

        writerService.save(writer);

        return "Writer has been created successfully";
    }
}
