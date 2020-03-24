package com.mikhail.ticket;

import com.mikhail.crudBase.BaseSearchService;

public interface TicketService extends BaseSearchService<Ticket, TicketFilter> {

    Ticket addTicket(Ticket ticket);

    Long checkSeats(Long movieSessionId);
}
