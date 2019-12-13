package com.mikhail.service;

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


}
