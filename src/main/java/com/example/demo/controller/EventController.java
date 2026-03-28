package com.example.demo.controller;

import com.example.demo.entity.Event;
import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private TicketService ticketService;

    // Create a new event, POST
    @PostMapping
    public Event create(@RequestBody Event event,
                        @RequestParam Integer organizerId,
                        @RequestParam Integer venueId) {
        return ticketService.createEvent(event, organizerId, venueId);
    }


    // List all upcoming events, GET
    @GetMapping
    public List<Event> listAllEvents() {
        return ticketService.getAllEvents();
    }

    // Get event details with ticket types, GET
    @GetMapping("/{id}")
    public Event getDetails(@PathVariable Integer id) {
        return ticketService.getEventDetails(id);
    }

    @GetMapping("/{id}/revenue")
    public Double getRevenue(@PathVariable Integer id) {
        return ticketService.calculateRevenue(id);
    }
}
