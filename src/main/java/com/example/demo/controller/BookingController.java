package com.example.demo.controller;

import com.example.demo.entity.Booking;
import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private TicketService ticketService;

    @PostMapping
    public Booking bookTicket(@RequestParam Integer attendeeId, @RequestParam Integer ticketTypeId) {
        return ticketService.bookingTicket(attendeeId, ticketTypeId);
    }

    @PutMapping("/{id}/cancel")
    public Booking cancelBooking(@PathVariable Integer id) {
        return ticketService.cancelBooking(id);
    }
}
