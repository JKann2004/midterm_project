package com.example.demo.repository;

import com.example.demo.entity.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Integer> {
    // findAllById() aka get all bookings for AN attendee
    Optional<Attendee> findByEmail(String email);

    @Query("SELECT a FROM Attendee a LEFT JOIN FETCH a.bookings WHERE a.attendeeId = :id")
    Optional<Attendee> findByIdWithBookings(@Param("id") Integer id);

}
