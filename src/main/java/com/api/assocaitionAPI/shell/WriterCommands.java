package com.api.assocaitionAPI.shell;

import com.api.assocaitionAPI.model.event.Post;
import com.api.assocaitionAPI.service.model.PostService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class WriterCommands {

    private final PostService postService;
    public WriterCommands(PostService postService) {
        this.postService = postService;
    }

    @PreAuthorize("hasAuthority('WRITE')")
    @ShellMethod(key = "create-post", value = "Creates Post")
    public String create_post(@ShellOption(value = "-t", help = "title VARCHAR(255)") String title) {

        Post post = new Post();
        post.setTitle(title);
        postService.save(post);

        return "Post created Successfully";
    }
}
