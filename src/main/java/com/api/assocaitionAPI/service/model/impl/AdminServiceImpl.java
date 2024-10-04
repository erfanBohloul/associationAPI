package com.api.assocaitionAPI.service.model.impl;

import com.api.assocaitionAPI.model.account.Admin;
import com.api.assocaitionAPI.model.account.Role;
import com.api.assocaitionAPI.service.model.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Override
    public Admin findById(Long id) {
        return null;
    }

    @Override
    public Admin save(Admin admin) {
        return null;
    }

    @Override
    public Admin update(Admin admin) {
        return null;
    }

    @Override
    public void delete(Admin admin) {

    }

    @Override
    public List<Admin> findAll() {
        return List.of();
    }

    @Override
    public void addRole(Admin admin, Role role) {

    }
}
