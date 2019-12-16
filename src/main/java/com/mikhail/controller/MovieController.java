package com.mikhail.controller;

import com.mikhail.dto.MovieDtoIn;
import com.mikhail.dto.MovieDtoOut;
import com.mikhail.mapper.MovieMapper;
import com.mikhail.service.impl.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper mapper;

    @GetMapping(value = "/movies")
    public ResponseEntity<List<MovieDtoOut>> getAllMovies() {
        return ResponseEntity.ok().body(mapper.toOut(movieService.findAllMovies()));
    }

    @GetMapping(value = "/movies/{id}")
    public ResponseEntity<MovieDtoOut> getMovie(@PathVariable(name = "id") Long movieId) {
        return ResponseEntity.ok().body(mapper.toOut(movieService.findMovie(movieId)));
    }

    @PostMapping("/movies")
    public ResponseEntity<MovieDtoOut> addMovie(
            @RequestBody @Valid MovieDtoIn dtoIn) {
//        MovieDtoOut dtoOut = movieService.
//        return ResponseEntity.created()/
    }
}
