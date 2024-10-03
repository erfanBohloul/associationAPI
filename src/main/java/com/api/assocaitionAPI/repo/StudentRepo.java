package com.api.assocaitionAPI.repo;

import com.api.assocaitionAPI.model.account.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
}
