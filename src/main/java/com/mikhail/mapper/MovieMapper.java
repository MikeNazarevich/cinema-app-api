package com.mikhail.mapper;

import com.mikhail.dto.movie.MovieDtoIn;
import com.mikhail.dto.movie.MovieDtoOut;
import com.mikhail.model.Movie;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MovieMapper extends DtoMapper<MovieDtoIn, MovieDtoOut, Movie> {

    @Mapping(target = "movieId", source = "id")
    MovieDtoOut toOut(Movie movie);

    List<MovieDtoOut> toOut(List<Movie> movies);

    Movie fromIn(MovieDtoIn dtoIn);
}
