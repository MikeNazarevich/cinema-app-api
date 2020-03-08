package com.mikhail.web.dto.ticket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TicketDtoOut {

    private Long row;
    private Long place;
    private Instant movieDate;
    private String movieName;

}
