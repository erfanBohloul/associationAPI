package com.api.assocaitionAPI.repo;

import com.api.assocaitionAPI.model.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Long> {
}
