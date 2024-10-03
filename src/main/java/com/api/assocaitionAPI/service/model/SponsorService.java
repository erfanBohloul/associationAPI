package com.api.assocaitionAPI.service.model;

import com.api.assocaitionAPI.model.event.Sponsor;

import java.util.List;

public interface SponsorService {
    Sponsor save(Sponsor sponsor);
    List<Sponsor> findAll();
    Sponsor findById(Long id);
    Sponsor update(Sponsor sponsor);
    void delete(Long id);
}
