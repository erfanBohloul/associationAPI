package com.api.assocaitionAPI.shell;

import com.api.assocaitionAPI.model.account.GrantedAuthority;
import com.api.assocaitionAPI.model.account.Role;
import com.api.assocaitionAPI.model.account.user.User;
import com.api.assocaitionAPI.model.account.user.Writer;
import com.api.assocaitionAPI.repo.GrantedAuthorityRepo;
import com.api.assocaitionAPI.repo.PostRepo;
import com.api.assocaitionAPI.repo.RoleRepo;
import com.api.assocaitionAPI.repo.UserRepo;
import com.api.assocaitionAPI.service.model.PostService;
import com.api.assocaitionAPI.service.model.WriterService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
public class AdminCommands {

    private final WriterService writerService;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    private final GrantedAuthorityRepo grantedAuthorityRepo;
    private final PostService postService;

    public AdminCommands(WriterService writerService, RoleRepo roleRepo, PasswordEncoder passwordEncoder, UserRepo userRepo, GrantedAuthorityRepo grantedAuthorityRepo, PostService postService) {
        this.writerService = writerService;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
        this.grantedAuthorityRepo = grantedAuthorityRepo;
        this.postService = postService;
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

    @PreAuthorize("hasAuthority('ADMIN')")
    @ShellMethod(key = "del post", value = "Deletes a Post")
    public String deletePost(@ShellOption(value = "-i", help = "id") long id) {
        postService.deleteById(id);
        return "Post has been deleted successfully";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ShellMethod(key = "del writer", value = "Deletes a Writer by username")
    public String deleteWriter(@ShellOption(value = "-u", help = "username") String username) {
        Writer writer = writerService.findByUsername(username);
        writerService.delete(writer.getId());
        return "Writer has been deleted successfully";
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @ShellMethod(key = "list writers", value = "make a list of writers")
    public String listWriter() {
        return listWriter((int) writerService.count());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ShellMethod(key = "list writers", value = "make a list of writers")
    public String listWriter(@ShellOption(value = "-n", help = "number of writer to show") int n) {
        List<Writer> writers = writerService.findAll();
        n = Integer.min(n, writers.size());

        for (int i = 0; i < n; i++) {
            System.out.println(writers.get(i).getUsername());
        }

        return "List of writer has been listed successfully";
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @ShellMethod(key = "grant auth", value = "grants an auth of an obj to a user")
    public String grantAuthority(@ShellOption(value = "-u", help = "username") String username,
                                 @ShellOption(value = "-p", help = "permission") String permission,
                                 @ShellOption(value = "-c", help = "path of the class(path starts from model folder)") String path,
                                 @ShellOption(value = "-i", help = "id of object") Long id) {

        path = "com.api.assocaitionAPI.model." + path;

        GrantedAuthority grantedAuthority = new GrantedAuthority();
        grantedAuthority.setPermission(permission);
        grantedAuthority.setObjectId(id);
        grantedAuthority.setObjectType(path);
        grantedAuthorityRepo.save(grantedAuthority);

        User user = userRepo.findByUsername(username);
        user.getAuthorities().add(grantedAuthority);
        userRepo.save(user);

        // TODO what we could do to prevent give auth to admins?
        return "granted " + grantedAuthority.getAuthority() + " to " + username;
    }
}
