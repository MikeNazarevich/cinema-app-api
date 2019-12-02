package com.mikhail.web;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphs;
import com.mikhail.ticket.Ticket;
import com.mikhail.ticket.TicketFilter;
import com.mikhail.ticket.TicketService;
import com.mikhail.web.dto.ticket.TicketDtoIn;
import com.mikhail.web.dto.ticket.TicketDtoOut;
import com.mikhail.web.dto.ticket.TicketUserDtoOut;
import com.mikhail.web.mapper.TicketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService service;
    private final TicketMapper mapper;

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<TicketUserDtoOut>> findAllForAdmin(TicketFilter filter) {
        return ResponseEntity.ok().body(mapper.toOutTicketFullInfo((List<Ticket>) service.findAll(filter, EntityGraphs.named("Ticket.full"))));
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') && @webSecurity.authBelongsToUserId(#filter.userId)")
    public ResponseEntity<List<TicketDtoOut>> findAll(TicketFilter filter) {
        return ResponseEntity.ok().body(mapper.toOut(service.findAll(filter, EntityGraphs.named("Ticket.movieSession"))));
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<TicketDtoOut> addTicket(@RequestBody final TicketDtoIn dtoIn) {
        return ResponseEntity.ok().body(mapper.toOut(service.addTicket(mapper.fromIn(dtoIn))));
    }

}
