package com.mikhail.service.impl;

import com.mikhail.dto.movie.MovieDtoIn;
import com.mikhail.dto.movie.MovieDtoOut;
import com.mikhail.exceptionHandler.ResourceNotFoundException;
import com.mikhail.mapper.MovieMapper;
import com.mikhail.model.Movie;
import com.mikhail.repository.MovieRepository;
import com.mikhail.service.api.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper mapper;

    public List<MovieDtoOut> findAllMovies() {
        return mapper.toOut(movieRepository.findAll());
    }

    public MovieDtoOut findMovie(final Long id) {
        return mapper.toOut(movieRepository.getOne(id));
    }

    public void addMovie(MovieDtoIn dtoIn) {
        movieRepository.save(mapper.fromIn(dtoIn));
    }

    public void updateMovie(final Long id, final MovieDtoIn dtoIn) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        mapper.merge(dtoIn, movie);
        movieRepository.save(movie);
    }

    public void deleteMovie(final Long id) {
        movieRepository.deleteById(id);
    }


}
