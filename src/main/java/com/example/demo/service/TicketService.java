package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private static AttendeeRepository attendeeRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private static EventRepository eventRepository;

    @Autowired
    private static OrganizerRepository organizerRepository;

    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    @Autowired
    private static VenueRepository venueRepository;

    // Create a new organizer
    public static Organizer createOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    // Create a new venue
    public static Venue createVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    // Create a new event
    public static Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    // List all upcoming events
    public static List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Get event details with ticket type
    public static Optional<Event> getEventDetails(Integer id) {
        return eventRepository.findById(id);
    }

    // Create a new attendee
    public static Attendee createAttendee(Attendee attendee) {
        return attendeeRepository.save(attendee);
    }

    // Get all bookings for an attendee
    public static List<Attendee> getAllBookings(Integer id) {
        return attendeeRepository.findAllById(id);
    }

    // Booking a ticket aka POST /api/bookings

    // Cancelling a Booking aka PUT /api/bookings/{id}/cancel

    // Revenue Calculation aka GET /api/events/{id}/revenue



}
