package com.api.assocaitionAPI.service.model.impl;

import com.api.assocaitionAPI.model.event.Post;
import com.api.assocaitionAPI.repo.PostRepo;
import com.api.assocaitionAPI.service.model.PostService;
import com.api.assocaitionAPI.service.model.WriterService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;
    private final WriterService writerService;

    public PostServiceImpl(PostRepo postRepo, WriterService writerService) {
        this.postRepo = postRepo;
        this.writerService = writerService;
    }

    @PreAuthorize("hasAuthority('WRITER')")
    @Override
    public Post save(Post post) {
        return postRepo.save(post);
    }

    @PreAuthorize("hasAuthority('WRITER')")
    @Override
    public Post update(Post post) {
        return postRepo.save(post);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'WRITER')")
    @Override
    public void delete(Post post) {
        writerService.deletePost(post.getWriter(), post);
        postRepo.delete(post);
    }

    @Override
    @PreAuthorize("hasAnyAuthority('ADMIN', 'WRITER')")
    public void deleteById(Long id) {
        delete(postRepo.findById(id).orElse(null));
    }

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postRepo.findById(id).orElse(null);
    }

    @PreAuthorize("hasPermission(#post, 'write')")
    @Override
    public void updateTitle(Post post, String title) {
        post.setTitle(title);
        postRepo.save(post);
    }


}
