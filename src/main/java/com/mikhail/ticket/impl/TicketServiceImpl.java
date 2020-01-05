package com.mikhail.ticket.impl;

import com.mikhail.crudBase.BaseSearchServiceImpl;
import com.mikhail.ticket.TicketFilter;
import com.mikhail.ticket.TicketService;
import com.mikhail.ticket.TicketSpec;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl extends BaseSearchServiceImpl<Ticket, TicketFilter, TicketSpec, TicketRepository>
        implements TicketService {

    public TicketServiceImpl(TicketRepository repository, TicketSpec spec) {
        super(repository, spec);
    }

//    @Override
//    public List<Ticket> findAll(TicketSpec spec) {
//        return getRepository().findAll(Specification.where(findB));
//    }
}
