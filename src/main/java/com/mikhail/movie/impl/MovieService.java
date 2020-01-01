package com.mikhail.movie.impl;

import com.mikhail.movie.MovieSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService {

    List<Movie> findAllMovies();

    Movie findMovie(Long id);

    void addMovie(Movie movie);

    void updateMovie(Movie movie);

    void deleteMovie(Long id);

    Page<Movie> findAll(MovieSpec spec, Pageable page);
}
