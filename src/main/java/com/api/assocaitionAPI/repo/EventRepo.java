package com.api.assocaitionAPI.repo;

import com.api.assocaitionAPI.model.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event, Long> {
}
