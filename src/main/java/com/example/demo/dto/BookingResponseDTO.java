package com.example.demo.dto;

import com.example.demo.entity.Attendee;
import com.example.demo.entity.Booking;
import com.example.demo.entity.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDTO {
    private String booking_reference;
    private Date booking_date;
    private PaymentStatus status;
    private String attendee_name;
    private String event_title;
    private String ticket_type_name;
    private Double price;
}
