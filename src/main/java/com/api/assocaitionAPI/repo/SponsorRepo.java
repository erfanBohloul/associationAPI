package com.api.assocaitionAPI.repo;

import com.api.assocaitionAPI.model.event.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SponsorRepo extends JpaRepository<Sponsor, Long> {
}
