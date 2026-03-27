package com.example.demo.controller;

import com.example.demo.entity.Event;
import com.example.demo.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private List<Event> events = new ArrayList<>();


    // Create a new event, POST
    @PostMapping("/api/events")
    public Event create(@RequestBody Event event) {
        return TicketService.createEvent(event);
    }

    // List all upcoming events, GET
    @GetMapping("/api/events")
    public List<Event> listAllEvents() {
        return TicketService.getAllEvents();
    }

    // Get event details with ticket types, GET
    @GetMapping("/api/events/{id}")
    public Optional<Event> getDetails(@RequestBody Integer id) {
        return TicketService.getEventDetails(id);
    }
}
