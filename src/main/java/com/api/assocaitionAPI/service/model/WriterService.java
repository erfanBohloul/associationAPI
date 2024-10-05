package com.api.assocaitionAPI.service.model;

import com.api.assocaitionAPI.model.account.user.Writer;

import java.util.List;

public interface WriterService {
    Writer save(Writer writer);
    Writer findById(Long id);
    void delete(Long id);
    Writer update(Writer writer);
    List<Writer> findAll();

}
