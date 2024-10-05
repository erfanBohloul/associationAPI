package com.api.assocaitionAPI.service.model;


import com.api.assocaitionAPI.model.event.Post;

import java.util.List;

public interface PostService {
    Post save(Post post);
    Post update(Post post);
    void delete(Post post);
    List<Post> findAll();
    Post findById(Long id);

}
