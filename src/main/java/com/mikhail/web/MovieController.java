package com.mikhail.web;

import com.mikhail.movie.MovieService;
import com.mikhail.web.dto.movie.MovieDtoIn;
import com.mikhail.web.dto.movie.MovieDtoOut;
import com.mikhail.web.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService service;
    private final MovieMapper mapper;

    @GetMapping("/movies")
    public ResponseEntity<Page<MovieDtoOut>> findAllMoviesPage(Pageable page) {
        return ResponseEntity.ok().body(mapper.toOut(service.findAllPage(page)));
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<MovieDtoOut> findMovie(@PathVariable final Long id) {
        return ResponseEntity.ok().body(mapper.toOut(service.findOneOrThrow(id)));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/movies")
    public ResponseEntity<MovieDtoOut> addMovie(@RequestBody @Valid final MovieDtoIn dtoIn) {
        return ResponseEntity.ok().body(mapper.toOut(service.addMovie(mapper.fromIn(dtoIn))));
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<MovieDtoOut> updateMovie(@PathVariable final Long id, @RequestBody @Valid final MovieDtoIn dtoIn) {
        service.updateMovie(id, dtoIn);
        return ResponseEntity.ok().body(mapper.toOut(service.updateMovie(id, dtoIn)));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable final Long id) {
        service.deleteMovie(id);
        return ResponseEntity.ok().build();
    }
}
