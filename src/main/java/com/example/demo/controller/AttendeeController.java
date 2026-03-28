package com.example.demo.controller;

import com.example.demo.dto.BookingResponseDTO;
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
    @Autowired
    private TicketService ticketService;

    // Register new attendee, POST
    @PostMapping
    public Attendee create(@RequestBody Attendee attendee) {
        return ticketService.createAttendee(attendee);
    }

    // Get all bookings for an attendee, GET
    @GetMapping("/{id}/bookings")
    public List<BookingResponseDTO> getBookingsByAttendee(@PathVariable Integer id) {
        return ticketService.getBookingsByAttendee(id);
    }
}
