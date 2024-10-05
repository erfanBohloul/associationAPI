package com.api.assocaitionAPI.service.model.impl;

import com.api.assocaitionAPI.model.event.Post;
import com.api.assocaitionAPI.repo.PostRepo;
import com.api.assocaitionAPI.service.model.PostService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;

    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
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
        postRepo.delete(post);
    }

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postRepo.findById(id).orElse(null);
    }
}
