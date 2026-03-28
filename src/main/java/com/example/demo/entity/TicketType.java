package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="ticket_type")
@Data
public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticketTypeId")
    private Integer ticketTypeId;

    private String name;

    @Column(nullable = false)
    private Double price;

    private Integer quantity_available;

    // Foreign Key
    @ManyToOne
    @JoinColumn(name = "eventId", nullable = false)
    private Event event;

    @OneToMany(mappedBy = "ticketType", cascade = CascadeType.ALL)
    private List<Booking> bookings;
}
