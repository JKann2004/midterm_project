package com.example.demo.repository;

import com.example.demo.entity.Event;
import com.example.demo.entity.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    // List all upcoming events
    List<Event> findByStatus(PaymentStatus status);
}
