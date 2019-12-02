package com.mikhail.ticket.impl;

import com.mikhail.crudBase.BaseSearchServiceImpl;
import com.mikhail.security.WebSecurity;
import com.mikhail.ticket.Ticket;
import com.mikhail.ticket.TicketFilter;
import com.mikhail.ticket.TicketService;
import com.mikhail.user.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Service
public class TicketServiceImpl extends BaseSearchServiceImpl<Ticket, TicketFilter, TicketSpec, TicketRepository>
        implements TicketService {

    private static final Long seatsNum = 5L;

    private final UserService userService;

    public TicketServiceImpl(TicketRepository repository, TicketSpec spec, UserService userService) {
        super(repository, spec);
        this.userService = userService;
    }

    @Override
    @Transactional
    public Ticket addTicket(@NotNull final Ticket ticket) {
        Long id = WebSecurity.getToken().getUserId();
        userService.findOne(id).ifPresent(ticket::setUser);

        if (countBusyPlaces(ticket.getMovieSession().getId()) <= seatsNum)
            return ticket;
        else return null;
    }

    @Override
    public Long countBusyPlaces(Long movieSessionId) {
        return getRepository().countTicketsByMovieSessionId(movieSessionId);
    }
}
