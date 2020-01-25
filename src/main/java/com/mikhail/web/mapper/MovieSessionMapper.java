package com.mikhail.web.mapper;

import com.mikhail.crudBase.DtoMapper;
import com.mikhail.movieSession.MovieSession;
import com.mikhail.web.dto.movieSession.MovieSessionDtoIn;
import com.mikhail.web.dto.movieSession.MovieSessionDtoOut;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MovieSessionMapper extends DtoMapper<MovieSessionDtoIn, MovieSessionDtoOut, MovieSession> {

    MovieSessionDtoOut toOut(MovieSession movieSession);

    void merge(MovieSessionDtoIn dtoIn, @MappingTarget MovieSession movieSession);

    List<MovieSessionDtoOut> toOut(List<MovieSession> movieSessions);

}
