package com.api.assocaitionAPI.service.model;

import com.api.assocaitionAPI.model.event.Staff;

import java.util.List;

public interface StaffService {
    Staff save(Staff staff);
    List<Staff> findAll();
    Staff findById(Long id);
    void delete(Long id);
}
