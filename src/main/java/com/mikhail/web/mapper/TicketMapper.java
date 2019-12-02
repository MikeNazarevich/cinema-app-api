package com.mikhail.web.mapper;

import com.mikhail.crudBase.DtoMapper;
import com.mikhail.ticket.Ticket;
import com.mikhail.web.dto.ticket.TicketDtoIn;
import com.mikhail.web.dto.ticket.TicketDtoOut;
import com.mikhail.web.dto.ticket.TicketUserDtoOut;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TicketMapper extends DtoMapper<Object, TicketDtoOut, Ticket> {

    @Mapping(target = "movieDate", source = "movieSession.movieDate")
    @Mapping(target = "movieName", source = "movieSession.movie.name")
    TicketDtoOut toOut(Ticket ticket);

    List<TicketDtoOut> toOut(List<Ticket> ticket);

    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "movieDate", source = "movieSession.movieDate")
    @Mapping(target = "movieName", source = "movieSession.movie.name")
    TicketUserDtoOut toOutTicketFullInfo(Ticket ticket);

    @Mapping(target = "movieSession.id", source = "movieSessionId")
    Ticket fromIn(TicketDtoIn dtoIn);

    List<TicketUserDtoOut> toOutTicketFullInfo(List<Ticket> tickets);

}
