package com.mikhail.ticket.impl;

import com.mikhail.crudBase.BaseSearchServiceImpl;
import com.mikhail.ticket.Ticket;
import com.mikhail.ticket.TicketFilter;
import com.mikhail.ticket.TicketService;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl extends BaseSearchServiceImpl<Ticket, TicketFilter, TicketSpec, TicketRepository>
        implements TicketService {

    public TicketServiceImpl(TicketRepository repository, TicketSpec spec) {
        super(repository, spec);
    }

    @Override
    public void addTicket(final Ticket ticket) {
        getRepository().save(ticket);
    }

}
