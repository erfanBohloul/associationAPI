package com.api.assocaitionAPI.repo;

import com.api.assocaitionAPI.model.account.GrantedAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrantedAuthorityRepo extends JpaRepository<GrantedAuthority, Long> {
}
