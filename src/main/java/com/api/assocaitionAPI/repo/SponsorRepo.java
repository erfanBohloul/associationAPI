package com.api.assocaitionAPI.repo;

import com.api.assocaitionAPI.model.event.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SponsorRepo extends JpaRepository<Sponsor, Long> {
}
