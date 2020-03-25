package com.mikhail.ticket.impl;

import com.mikhail.crudBase.BaseSearchServiceImpl;
import com.mikhail.security.CustomKeycloakAuthenticationProvider;
import com.mikhail.ticket.Ticket;
import com.mikhail.ticket.TicketFilter;
import com.mikhail.ticket.TicketService;
import com.mikhail.user.User;
import com.mikhail.user.UserService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

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
    public Ticket addTicket(@NotNull final Ticket ticket) {
        String iamId = CustomKeycloakAuthenticationProvider.getCurrentUserLogin();
        Optional<User> user = userService.findByIamId(iamId);
        user.ifPresent(ticket::setUser);

        if (countBusyPlaces(ticket.getMovieSession().getId()) <= seatsNum)
            return getRepository().save(ticket);
        else return null;
    }

    @Override
    public Long countBusyPlaces(Long movieSessionId) {
        return getRepository().countTicketsByMovieSessionId(movieSessionId);
    }

}
