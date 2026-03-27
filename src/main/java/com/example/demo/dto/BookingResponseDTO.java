package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDTO {
    private String booking_reference;
    private Date date;
    private String status;
    private String attendee_name;
    private String event_title;
    private String ticket_type_name;
    private Double price;
}
