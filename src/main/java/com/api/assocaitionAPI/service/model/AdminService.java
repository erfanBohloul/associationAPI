package com.api.assocaitionAPI.service.model;

import com.api.assocaitionAPI.model.account.user.Admin;
import com.api.assocaitionAPI.model.account.Role;

import java.util.List;

public interface AdminService {

    Admin findById(Long id);
    Admin save(Admin admin);
    Admin update(Admin admin);
    void delete(Admin admin);
    List<Admin> findAll();
    void addRole(Admin admin, Role role);
}
