package com.api.assocaitionAPI.service.model;

import com.api.assocaitionAPI.model.account.user.Writer;
import com.api.assocaitionAPI.model.event.Post;

import java.util.List;

public interface WriterService {
    Writer save(Writer writer);
    Writer findById(Long id);
    void delete(Long id);
    void deletePost(Writer writer, Post post);
    Writer update(Writer writer);
    List<Writer> findAll();
    Writer findByUsername(String username);
    long count();

}
