package com.api.assocaitionAPI.service.model.impl;

import com.api.assocaitionAPI.model.event.Event;
import com.api.assocaitionAPI.repo.EventRepo;
import com.api.assocaitionAPI.service.model.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepo eventRepo;
    public EventServiceImpl(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public List<Event> findAll() {
        return eventRepo.findAll();
    }

    @Override
    public Event findById(Long id) {
        return eventRepo.findById(id).orElse(null);
    }

    @Override
    public Event save(Event event) {
        return eventRepo.save(event);
    }

    @Override
    public Event update(Event event) {
        return eventRepo.save(event);
    }

    @Override
    public void delete(Long id) {
        eventRepo.deleteById(id);
    }
}
