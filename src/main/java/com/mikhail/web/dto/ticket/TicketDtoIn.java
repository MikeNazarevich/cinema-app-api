package com.mikhail.web.dto.ticket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TicketDtoIn {

    @NotBlank
    private Long range;

    @NotBlank
    private Long place;

    @NotBlank
    private Long movieSessionId;
}
