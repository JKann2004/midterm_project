package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name="booking")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingId")
    private Integer bookingId;

    private String booking_reference;

    @Temporal(TemporalType.TIMESTAMP)
    private Date booking_date;

    @Enumerated(EnumType.STRING)
    private PaymentStatus payment_status;

    // Foreign Keys
    @ManyToOne
    @JoinColumn(name = "attendeeId", nullable = false)
    private Attendee attendee;

    @ManyToOne
    @JoinColumn(name = "ticketTypeId", nullable = false)
    private TicketType ticketType;

}

