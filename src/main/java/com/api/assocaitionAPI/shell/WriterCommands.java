package com.api.assocaitionAPI.shell;

import com.api.assocaitionAPI.model.account.GrantedAuthority;
import com.api.assocaitionAPI.model.account.user.Writer;
import com.api.assocaitionAPI.model.event.Post;
import com.api.assocaitionAPI.repo.GrantedAuthorityRepo;
import com.api.assocaitionAPI.service.model.PostService;
import com.api.assocaitionAPI.service.model.WriterService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class WriterCommands {

    private final PostService postService;
    private final WriterService writerService;
    private final GrantedAuthorityRepo grantedAuthorityRepo;

    public WriterCommands(PostService postService, WriterService writerService, GrantedAuthorityRepo grantedAuthorityRepo) {
        this.postService = postService;
        this.writerService = writerService;
        this.grantedAuthorityRepo = grantedAuthorityRepo;
    }

    @PreAuthorize("hasAuthority('WRITER')")
    @ShellMethod(key = "create-post", value = "Creates Post")
    public String create_post(@ShellOption(value = "-t", help = "title VARCHAR(255)") String title) {

        User user = getUser();
        Writer writer = writerService.findByUsername(user.getUsername());

        // post
        Post post = new Post();
        post.setTitle(title);
        post.setWriter(writer);
        postService.update(post);
        writer.getPosts().add(post);

        // permission to write
        GrantedAuthority authority = new GrantedAuthority();
        authority.setObjectId(post.getId());
        authority.setPermission("WRITE");
        authority.setObjectType("com.api.assocaitionAPI.model.event.post");
        grantedAuthorityRepo.save(authority);
        writer.getAuthorities().add(authority);

        writerService.update(writer);

        return "Post created Successfully";
    }
    // login admin password
    // grant auth -p write -u erfan -c event.post -i 1
    // login erfan password
    // update-post 1 tttt


    @ShellMethod(key = "update-post", value="updates post")
    public String update_post(@ShellOption(value = "-i", help = "post id") Long id,
            @ShellOption(value = "-t", help = "title") String title) {

        Post post = postService.findById(id);
        postService.updateTitle(post, title);
        return "Post updated Successfully";
    }

    private User getUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @PreAuthorize("hasAuthority('WRITER')")
    @ShellMethod(key = "show auths", value = "show authorities")
    public String showAuthorities() {
        Writer writer = writerService.findByUsername(getUser().getUsername());

        for (GrantedAuthority authority : writer.getAuthorities()) {
            System.out.println(authority.getAuthority());
        }

        return "end of authorities";
    }

}
