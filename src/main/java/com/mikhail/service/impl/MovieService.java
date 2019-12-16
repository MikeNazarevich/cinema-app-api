package com.mikhail.service.impl;

import com.mikhail.model.Movie;
import com.mikhail.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public Movie findMovie(Long id) {
        return movieRepository.getOne(id);
    }

//    public Movie addMovie()


}
