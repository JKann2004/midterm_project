package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendeeBookingsDTO {
    private String attendee_name;
    private List<BookingResponseDTO> booking_response;
}
