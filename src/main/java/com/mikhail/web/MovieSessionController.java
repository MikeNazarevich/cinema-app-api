package com.mikhail.web;

import com.mikhail.movieSession.MovieSessionFilter;
import com.mikhail.movieSession.MovieSessionService;
import com.mikhail.web.dto.movie.MovieDtoIn;
import com.mikhail.web.dto.movieSession.MovieSessionDtoIn;
import com.mikhail.web.dto.movieSession.MovieSessionDtoOut;
import com.mikhail.web.mapper.MovieSessionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MovieSessionController {

    private final MovieSessionService service;
    private final MovieSessionMapper mapper;

    @GetMapping("/sessions")
    public ResponseEntity<Page<MovieSessionDtoOut>> findAllMovieSessionsPage(MovieSessionFilter filter, Pageable page) {
        return ResponseEntity.ok().body(mapper.toOut(service.findAllPage(filter, page)));
    }

    @GetMapping("/sessions/{id}")
    public ResponseEntity<MovieSessionDtoOut> findMovieSession(@PathVariable final Long id) {
        return ResponseEntity.ok().body(mapper.toOut(service.findOneOrThrow(id)));
    }

    @PostMapping("/movies")
    public ResponseEntity<Void> addMovieSession(final MovieSessionDtoIn dtoIn) {
        service.addMovieSession(mapper.fromIn(dtoIn));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Void> updateMovieSession(@PathVariable final Long id, MovieDtoIn dtoIn) {
        service.updateMovieSession(id, dtoIn);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovieSession(@PathVariable final Long id) {
        service.deleteMovieSession(id);
        return ResponseEntity.ok().build();
    }

}
