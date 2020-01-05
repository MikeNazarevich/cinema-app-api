package com.mikhail.web;

import com.mikhail.ticket.TicketFilter;
import com.mikhail.ticket.TicketService;
import com.mikhail.web.dto.ticket.TicketDtoOut;
import com.mikhail.web.mapper.TicketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TicketController {

    private final TicketService service;
    private final TicketMapper mapper;

    @GetMapping("/tickets")
    public ResponseEntity<List<TicketDtoOut>> findAll(TicketFilter filter) {
        return ResponseEntity.ok().body(mapper.toOut(service.findAll(filter)));
    }
}
