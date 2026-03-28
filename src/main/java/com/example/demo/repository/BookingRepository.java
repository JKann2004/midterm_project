package com.example.demo.repository;

import com.example.demo.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByAttendeeAttendeeId(Integer attendeeId);

    boolean existsByAttendeeAttendeeIdAndTicketTypeTicketTypeId(Integer attendeeId, Integer ticketTypeId);

    @Query("SELECT SUM(b.ticketType.price) FROM Booking b WHERE b.ticketType.event.eventId = :eventId AND b.payment_status = 'CONFIRMED'")
    Double calculateTotalRevenue(@Param("eventId") Integer eventId);
}
