package com.api.assocaitionAPI.repo;

import com.api.assocaitionAPI.model.account.user.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WriterRepo extends JpaRepository<Writer, Long> {
}
