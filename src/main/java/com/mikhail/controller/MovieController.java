package com.mikhail.controller;

import com.mikhail.dto.movie.MovieDtoIn;
import com.mikhail.dto.movie.MovieDtoOut;
import com.mikhail.service.impl.MovieServiceImpl;
import com.mikhail.specifications.MovieSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieServiceImpl movieServiceImpl;

    @GetMapping(value = "/movies")
    public ResponseEntity<List<MovieDtoOut>> getAllMovies() {
        return ResponseEntity.ok().body(movieServiceImpl.findAllMovies());
    }

    public ResponseEntity<Page<MovieDtoOut>> getMovies(MovieSpecifications spec) {
        return ResponseEntity.ok().body(movieServiceImpl.findAll(spec));
    }

    @GetMapping(value = "/movies/{id}")
    public ResponseEntity<MovieDtoOut> getMovie(@PathVariable(name = "id") final Long movieId) {
        return ResponseEntity.ok().body(movieServiceImpl.findMovie(movieId));
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
