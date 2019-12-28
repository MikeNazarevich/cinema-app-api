package com.mikhail.service.impl;

import com.mikhail.dto.movie.MovieDtoIn;
import com.mikhail.exceptionHandler.ResourceNotFoundException;
import com.mikhail.mapper.MovieMapper;
import com.mikhail.model.Movie;
import com.mikhail.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper mapper;

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public Movie findMovie(Long id) {
        return movieRepository.getOne(id);
    }

    public void addMovie(MovieDtoIn dtoIn) {
        movieRepository.save(mapper.fromIn(dtoIn));
    }

    public void updateMovie(final Long id, final MovieDtoIn dtoIn) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        mapper.merge(dtoIn, movie);
        movieRepository.save(movie);

    }


}
