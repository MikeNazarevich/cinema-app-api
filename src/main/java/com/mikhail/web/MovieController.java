package com.mikhail.web;

import com.mikhail.movie.MovieFilter;
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
    public ResponseEntity<Page<MovieDtoOut>> findAllMoviesPage(MovieFilter filter, Pageable page) {
        return ResponseEntity.ok().body(mapper.toOut(service.findAllPage(filter, page)));
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<MovieDtoOut> findMovie(@PathVariable final Long id) {
        return ResponseEntity.ok().body(mapper.toOut(service.findOneOrThrow(id)));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/movies")
    public ResponseEntity<Void> addMovie(
            @RequestBody @Valid final MovieDtoIn dtoIn) {
        service.addMovie(mapper.fromIn(dtoIn));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Void> updateMovie(@PathVariable final Long id, @RequestBody @Valid final MovieDtoIn dtoIn) {
        service.updateMovie(id, dtoIn);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable final Long id) {
        service.deleteMovie(id);
        return ResponseEntity.ok().build();
    }
}
