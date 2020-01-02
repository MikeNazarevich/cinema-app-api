package com.mikhail.ticket;

import com.mikhail.ticket.impl.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> findAll(TicketSpec spec);
}
