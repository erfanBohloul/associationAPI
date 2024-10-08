package com.api.assocaitionAPI.repo;

import com.api.assocaitionAPI.model.event.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepo extends JpaRepository<Staff, Long> {
}
