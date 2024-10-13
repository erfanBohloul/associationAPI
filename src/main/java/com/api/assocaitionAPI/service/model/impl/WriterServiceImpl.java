package com.api.assocaitionAPI.service.model.impl;

import com.api.assocaitionAPI.model.account.user.Writer;
import com.api.assocaitionAPI.model.event.Post;
import com.api.assocaitionAPI.repo.WriterRepo;
import com.api.assocaitionAPI.service.model.WriterService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriterServiceImpl implements WriterService {

    private final WriterRepo writerRepo;
    public WriterServiceImpl(WriterRepo writerRepo) {
        this.writerRepo = writerRepo;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public Writer save(Writer writer) {
        return writerRepo.save(writer);
    }

    @Override
    public Writer findById(Long id) {
        return writerRepo.findById(id).orElse(null);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public void delete(Long id) {
        writerRepo.deleteById(id);
    }

    @Override
    public void deletePost(Writer writer,  Post post) {
        writer.getPosts().remove(post);
        writerRepo.save(writer);
    }

    @Override
    public Writer update(Writer writer) {
        return writerRepo.save(writer);
    }

    @Override
    public List<Writer> findAll() {
        return writerRepo.findAll();
    }


    @Override
    public Writer findByUsername(String username) {
        return writerRepo.findByUsername(username);
    }

    @Override
    public long count() {
        return writerRepo.count();
    }
}
