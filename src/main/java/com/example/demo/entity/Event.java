package com.example.demo.entity;

import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "event")
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventId")
    private Integer eventId;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private Date event_date;

    @Enumerated(EnumType.STRING)
    private Status status;

    // Foreign Keys
    @ManyToOne
    @JoinColumn(name = "organizerId", nullable = false)
    private Organizer organizer;

    @ManyToOne
    @JoinColumn(name = "venueId", nullable = false)
    private Venue venue;

    // Reference to the foreign key in Events
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<TicketType> ticketTypes;

}

