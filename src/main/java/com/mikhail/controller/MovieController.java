package com.mikhail.controller;

import com.mikhail.MovieDto;
import com.mikhail.mapper.MovieMapper;
import com.mikhail.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper mapper;

    @GetMapping(value = "/movies")
    public List<MovieDto> getAllMovies() {
        return mapper.fromJpa(movieService.findAllMovies());
    }
}
