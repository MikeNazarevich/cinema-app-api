package com.mikhail.service.api;

import com.mikhail.dto.movie.MovieDtoIn;
import com.mikhail.dto.movie.MovieDtoOut;

import java.util.List;

public interface MovieService {

    List<MovieDtoOut> findAllMovies();

    MovieDtoOut findMovie(Long id);

    void addMovie(MovieDtoIn dtoIn);

    void updateMovie(Long id, MovieDtoIn dtoIn);

    void deleteMovie(Long id);
}
