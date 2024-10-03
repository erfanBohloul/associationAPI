package com.api.assocaitionAPI.service.model.impl;

import com.api.assocaitionAPI.model.event.Sponsor;
import com.api.assocaitionAPI.repo.SponsorRepo;
import com.api.assocaitionAPI.service.model.SponsorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SponsorServiceImpl implements SponsorService {

    private final SponsorRepo sponsorRepo;
    public SponsorServiceImpl(SponsorRepo sponsorRepo) {
        this.sponsorRepo = sponsorRepo;
    }

    @Override
    public Sponsor save(Sponsor sponsor) {
        return sponsorRepo.save(sponsor);
    }

    @Override
    public List<Sponsor> findAll() {
        return sponsorRepo.findAll();
    }

    @Override
    public Sponsor findById(Long id) {
        return sponsorRepo.findById(id).orElse(null);
    }

    @Override
    public Sponsor update(Sponsor sponsor) {
        return sponsorRepo.save(sponsor);
    }

    @Override
    public void delete(Long id) {
        sponsorRepo.deleteById(id);
    }
}
