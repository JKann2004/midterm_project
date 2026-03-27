package com.example.demo.controller;

import com.example.demo.entity.Organizer;
import com.example.demo.entity.Venue;
import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/venues")
public class VenueController {
    private List<Venue> venues = new ArrayList<>();

    // Create a new venue, POST
    @PostMapping("/api/venue")
    public Venue create(@RequestBody Venue venue) {
        return TicketService.createVenue(venue);
    }
}
