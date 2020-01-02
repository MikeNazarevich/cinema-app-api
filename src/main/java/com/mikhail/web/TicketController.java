package com.mikhail.web;

import com.mikhail.ticket.TicketService;
import com.mikhail.ticket.TicketSpec;
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
    public ResponseEntity<List<TicketDtoOut>> findAll(TicketSpec spec) {
        return ResponseEntity.ok().build(service.)
    }
}
