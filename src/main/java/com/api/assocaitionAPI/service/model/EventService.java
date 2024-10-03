package com.api.assocaitionAPI.service.model;

import com.api.assocaitionAPI.model.event.Event;

import java.util.List;

public interface EventService {

    public List<Event> findAll();
    public Event findById(Long id);
    public Event save(Event event);
    public Event update(Event event);
    public void delete(Long id);
}
