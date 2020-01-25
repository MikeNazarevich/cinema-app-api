package com.mikhail.web.mapper;

import com.mikhail.crudBase.DtoMapper;
import com.mikhail.movie.Movie;
import com.mikhail.web.dto.movie.MovieDtoIn;
import com.mikhail.web.dto.movie.MovieDtoOut;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MovieMapper extends DtoMapper<MovieDtoIn, MovieDtoOut, Movie> {

    MovieDtoOut toOut(Movie movie);

    List<MovieDtoOut> toOut(List<Movie> movies);

    Movie fromIn(MovieDtoIn dtoIn);

    void merge(MovieDtoIn dtoIn, @MappingTarget Movie movie);
}
