package com.example.demo.controller;

import com.example.demo.entity.Attendee;
import com.example.demo.entity.Booking;
import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/attendee")
public class AttendeeController {
    private List<Attendee> attendees = new ArrayList<>();

    private Long nextId = 1L;

    public AttendeeController() {
        attendees.add(new Attendee());
    }

    // Register new attendee, POST
    @PostMapping("/api/attendees")
    public Attendee create(@RequestBody Attendee attendee) {
        return TicketService.createAttendee(attendee);
    }

    // Get all bookings for an attendee, GET
    @GetMapping("/api/attendees/{id}/bookings")
    public List<Attendee> getBookingsByAttendee(@RequestBody Integer id) {
        return TicketService.getAllBookings(id);
    }
}
