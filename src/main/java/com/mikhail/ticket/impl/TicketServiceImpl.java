package com.mikhail.ticket.impl;

import com.mikhail.ticket.TicketService;
import com.mikhail.ticket.TicketSpec;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository repository;

    public TicketServiceImpl(TicketRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Ticket> findAll(TicketSpec spec) {
        return repository.findAll(Specification.where(findB));
    }
}
