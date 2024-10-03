package com.api.assocaitionAPI.service.model;

import com.api.assocaitionAPI.model.company.Company;

import java.util.List;

public interface CompanyService {

    Company save(Company company);
    List<Company> findAll();
    Company findById(Long id);
    void deleteById(Long id);
}
