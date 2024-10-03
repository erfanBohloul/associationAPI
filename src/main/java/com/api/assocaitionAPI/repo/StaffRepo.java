package com.api.assocaitionAPI.repo;

import com.api.assocaitionAPI.model.event.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepo extends JpaRepository<Staff, Long> {
}
