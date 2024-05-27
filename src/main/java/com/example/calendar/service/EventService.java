package com.example.calendar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.calendar.model.Event;
import com.example.calendar.repository.JpaEventRepository;

@Service
public class EventService {

    @Autowired
    private JpaEventRepository jpaEventRepository;
    
    
    public List<Event> getAllEvents() {
        return jpaEventRepository.findAll();
    }

    public Event addEvent(Event event) {
        return jpaEventRepository.save(event);
    }

    public Event editEvent(Long eventId, Event updatedEvent) {
        Event event = jpaEventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + eventId));
        
        event.setTitle(updatedEvent.getTitle());
        event.setDescription(updatedEvent.getDescription());
        event.setDate(updatedEvent.getDate());
        
        return jpaEventRepository.save(event);
    }

    public void deleteEvent(Long eventId) {
        Event event = jpaEventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + eventId));
        
        jpaEventRepository.delete(event);
    }
    
   
}
