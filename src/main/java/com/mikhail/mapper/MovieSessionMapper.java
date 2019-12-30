package com.mikhail.mapper;

import com.mikhail.dto.movieSession.MovieSessionDtoIn;
import com.mikhail.dto.movieSession.MovieSessionDtoOut;
import com.mikhail.model.MovieSession;
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
