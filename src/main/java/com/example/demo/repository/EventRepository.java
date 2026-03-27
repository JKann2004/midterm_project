package com.example.demo.repository;

import com.example.demo.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    // save(entity) aka create a new event

    // findAll() list all upcoming events

    // findById(id) aka get event details with ticket type
    List<Event> findEventByTicketType(Integer id);


    // find all by event use custom @Query


}
