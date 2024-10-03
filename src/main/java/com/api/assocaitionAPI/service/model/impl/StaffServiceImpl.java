package com.api.assocaitionAPI.service.model.impl;

import com.api.assocaitionAPI.model.event.Staff;
import com.api.assocaitionAPI.repo.StaffRepo;
import com.api.assocaitionAPI.service.model.StaffService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffRepo staffRepo;
    public StaffServiceImpl(StaffRepo staffRepo) {
        this.staffRepo = staffRepo;
    }

    @Override
    public Staff save(Staff staff) {
        return staffRepo.save(staff);
    }

    @Override
    public List<Staff> findAll() {
        return staffRepo.findAll();
    }

    @Override
    public Staff findById(Long id) {
        return staffRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        staffRepo.deleteById(id);
    }
}
