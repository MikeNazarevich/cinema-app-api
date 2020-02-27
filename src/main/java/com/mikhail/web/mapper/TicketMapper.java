package com.mikhail.web.mapper;

import com.mikhail.crudBase.DtoMapper;
import com.mikhail.ticket.Ticket;
import com.mikhail.web.dto.ticket.TicketDtoOut;
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

}
