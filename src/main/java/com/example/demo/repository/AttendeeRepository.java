package com.example.demo.repository;

import com.example.demo.entity.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Integer> {
    // findAllById() aka get all bookings for AN attendee
    List<Attendee> findAllById(Integer id);

    // save(entity) aka Register new Attendee
}
