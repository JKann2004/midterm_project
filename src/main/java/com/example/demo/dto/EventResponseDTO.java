package com.example.demo.dto;

import com.example.demo.entity.Event;
import com.example.demo.entity.Organizer;
import com.example.demo.entity.TicketType;
import com.example.demo.entity.Venue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventResponseDTO {
    private Integer eventId;
    private String title;
    private String description;
    private Date event_date;
    private String status;
    private String organizer_name;
    private String venue_name;
    private List<TicketTypeDTO> ticketTypes;
}

