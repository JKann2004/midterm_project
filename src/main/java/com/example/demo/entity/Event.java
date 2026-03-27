package com.example.demo.entity;

import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Event")
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer event_id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private Date event_date;

    @Enumerated(EnumType.STRING)
    private Status status;

    // Foreign Keys
    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Organizer organizer_id;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue_id;

    // Reference to the foreign key in Events
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<TicketType> ticket_type;

}

enum Status {
    UPCOMING,
    ONGOING,
    CANCELLED,
    COMPLETED
}