package com.example.demo.controller;

import com.example.demo.entity.Organizer;
import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/organizers")
public class OrganizerController {
    private List<Organizer> organizers = new ArrayList<>();

    // Create a new organizer, POST
    @PostMapping("/api/organizers")
    public Organizer create(@RequestBody Organizer organizer) {
        return TicketService.createOrganizer(organizer);
    }
}
