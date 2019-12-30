package com.mikhail.controller;

import com.mikhail.dto.movie.MovieDtoIn;
import com.mikhail.dto.movie.MovieDtoOut;
import com.mikhail.mapper.MovieMapper;
import com.mikhail.service.impl.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieServiceImpl movieServiceImpl;
    private final MovieMapper mapper;

    @GetMapping(value = "/movies")
    public ResponseEntity<List<MovieDtoOut>> getAllMovies() {
        return ResponseEntity.ok().body(mapper.toOut(movieServiceImpl.findAllMovies()));
    }

    @GetMapping(value = "/movies/{id}")
    public ResponseEntity<MovieDtoOut> getMovie(@PathVariable(name = "id") final Long movieId) {
        return ResponseEntity.ok().body(mapper.toOut(movieServiceImpl.findMovie(movieId)));
    }

    @PostMapping("/movies")
    public ResponseEntity<Void> addMovie(
            @RequestBody @Valid MovieDtoIn dtoIn) {
        movieServiceImpl.addMovie(dtoIn);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Void> updateMovie(@PathVariable final Long id, final MovieDtoIn dtoIn) {
        movieServiceImpl.updateMovie(id, dtoIn);
        return ResponseEntity.ok().build();
    }
}
