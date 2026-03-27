package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name="Booking")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer booking_id;

    private String booking_reference;
    private Date booking_date;
    @Enumerated
    private PaymentStatus payment_status;

    // Foreign Keys
    @ManyToOne
    @JoinColumn(name = "attendee_id")
    private Attendee attendee_id;

    @ManyToOne
    @JoinColumn(name = "ticket_type_id")
    private TicketType ticket_type_id;

}
enum PaymentStatus {
    PENDING,
    CONFIRMED,
    CANCELLED
}