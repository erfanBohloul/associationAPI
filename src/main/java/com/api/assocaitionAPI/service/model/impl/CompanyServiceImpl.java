package com.api.assocaitionAPI.service.model.impl;

import com.api.assocaitionAPI.model.company.Company;
import com.api.assocaitionAPI.repo.CompanyRepo;
import com.api.assocaitionAPI.service.model.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepo companyRepo;
    public CompanyServiceImpl(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override
    public Company save(Company company) {
        return this.companyRepo.save(company);
    }

    @Override
    public List<Company> findAll() {
        return companyRepo.findAll();
    }

    @Override
    public Company findById(Long id) {
        return companyRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        companyRepo.deleteById(id);
    }
}
