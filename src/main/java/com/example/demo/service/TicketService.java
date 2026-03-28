package com.example.demo.service;

import com.example.demo.dto.BookingResponseDTO;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private AttendeeRepository attendeeRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private OrganizerRepository organizerRepository;

    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    @Autowired
    private VenueRepository venueRepository;

    // Create a new organizer
    public Organizer createOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    // Create a new venue
    public Venue createVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    // Create a new event
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    // List all upcoming events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Get event details with ticket type
    public Event getEventDetails(Integer id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
    }

    // Create a new attendee
    public Attendee createAttendee(Attendee attendee) {
        return attendeeRepository.save(attendee);
    }

    // Get all bookings for an attendee
    public List<Booking> getAllBookings(Integer attendeeId) {
        return bookingRepository.findByAttendeeAttendeeId(attendeeId);
    }

    // Booking a ticket aka POST /api/bookings
    @Transactional
    public Booking bookingTicket(Integer attendeeId, Integer ticketTypeId) {
        Attendee attendee = attendeeRepository.findById(attendeeId)
                .orElseThrow(() -> new RuntimeException("Attendee not found"));

        TicketType ticketType = ticketTypeRepository.findById(ticketTypeId)
                .orElseThrow(() -> new RuntimeException("TicketType not found"));

        if (ticketType.getQuantity_available() <= 0) {
            throw new RuntimeException("Sorry, this ticket type is sold out.");
        }

        if (bookingRepository.existsByAttendeeAttendeeIdAndTicketTypeTicketTypeId(attendeeId, ticketTypeId)) {
            throw new RuntimeException("You have already booked this ticket type.");
        }

        Booking booking = new Booking();
        booking.setAttendee(attendee);
        booking.setTicketType(ticketType);
        booking.setPayment_status(PaymentStatus.CONFIRMED);
        booking.setBooking_date(new Date());
        Booking savedBooking = bookingRepository.save(booking);

        ticketType.setQuantity_available(ticketType.getQuantity_available() - 1);
        ticketTypeRepository.save(ticketType);
        String bookingRef = String.format("TKT-%d-%05d",
                java.time.Year.now().getValue(),
                savedBooking.getBookingId());
        savedBooking.setBooking_reference(bookingRef);

        return bookingRepository.save(savedBooking);
    }
    // Cancelling a Booking aka PUT /api/bookings/{id}/cancel
    @Transactional
    public Booking cancelBooking(Integer bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        if (booking.getPayment_status() == PaymentStatus.CANCELLED) {
            throw new RuntimeException("Booking already cancelled");
        }

        booking.setPayment_status(PaymentStatus.CANCELLED);

        TicketType ticketType = booking.getTicketType();
        ticketType.setQuantity_available(ticketType.getQuantity_available() + 1);
        ticketTypeRepository.save(ticketType);

        return bookingRepository.save(booking);
    }

    // Revenue Calculation aka GET /api/events/{id}/revenue
    public double calculateRevenue(Integer eventId) {
        Double revenue = bookingRepository.calculateTotalRevenue(eventId);
        return revenue != null ? revenue : 0.0;
    }

    public List<BookingResponseDTO> getBookingsByAttendee(Integer attendeeId) {
        List<Booking> bookings = bookingRepository.findByAttendeeAttendeeId(attendeeId);

        return bookings.stream().map(b -> {
            BookingResponseDTO dto = new BookingResponseDTO();
            dto.setBooking_reference(b.getBooking_reference());
            dto.setBooking_date(b.getBooking_date());
            dto.setStatus(b.getPayment_status());
            dto.setAttendee_name(b.getAttendee().getName());
            dto.setEvent_title(b.getTicketType().getEvent().getTitle());
            dto.setTicket_type_name(b.getTicketType().getName());
            dto.setPrice(b.getTicketType().getPrice());
            return dto;
        }).toList();
    }

}
