package com.api.assocaitionAPI.repo;

import com.api.assocaitionAPI.model.account.user.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}
