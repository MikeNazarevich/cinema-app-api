package com.mikhail.web;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphs;
import com.mikhail.movieSession.MovieSessionFilter;
import com.mikhail.movieSession.MovieSessionService;
import com.mikhail.web.dto.movieSession.MovieSessionDtoIn;
import com.mikhail.web.dto.movieSession.MovieSessionDtoOut;
import com.mikhail.web.mapper.MovieSessionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MovieSessionController {

    private final MovieSessionService service;
    private final MovieSessionMapper mapper;

    @GetMapping("/sessions")
    public ResponseEntity<Page<MovieSessionDtoOut>> findAllMovieSessionsPage(MovieSessionFilter filter, Pageable page) {
        return ResponseEntity.ok().body(mapper.toOut(service.findAllPage(filter, page, EntityGraphs.named("Session.movie"))));
    }

    @GetMapping("/sessions/{id}")
    public ResponseEntity<MovieSessionDtoOut> findMovieSession(@PathVariable final Long id) {
        return ResponseEntity.ok().body(mapper.toOut(service.findOneOrThrow(id)));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/sessions")
    public ResponseEntity<MovieSessionDtoOut> addMovieSession(@RequestBody @Valid final MovieSessionDtoIn dtoIn) {
        return ResponseEntity.ok().body(mapper.toOut(service.addMovieSession(mapper.fromIn(dtoIn))));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/sessions/{id}")
    public ResponseEntity<MovieSessionDtoOut> updateMovieSession(@PathVariable final Long id, @RequestBody @Valid final MovieSessionDtoIn dtoIn) {
        return ResponseEntity.ok().body(mapper.toOut(service.updateMovieSession(id, dtoIn)));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/sessions/{id}")
    public ResponseEntity<Void> deleteMovieSession(@PathVariable final Long id) {
        service.deleteMovieSession(id);
        return ResponseEntity.ok().build();
    }

}
