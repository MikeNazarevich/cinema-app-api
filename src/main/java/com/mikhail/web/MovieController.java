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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService service;
    private final MovieMapper mapper;

    @GetMapping("/movies")
    public ResponseEntity<Page<MovieDtoOut>> getAllMoviesPage(MovieFilter filter, Pageable page) {
        return ResponseEntity.ok().body(mapper.toOut(service.findAllPage(filter, page)));
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<MovieDtoOut> getMovie(@PathVariable Long id) {
        return ResponseEntity.ok().body(mapper.toOut(service.findOneOrThrow(id)));
    }

    @PostMapping("/movies")
    public ResponseEntity<Void> addMovie(
            @RequestBody @Valid MovieDtoIn dtoIn) {
        service.addMovie(mapper.fromIn(dtoIn));
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/movies/{id}")
    public ResponseEntity<Void> updateMovie(@PathVariable final Long id, @RequestBody @Valid final Map<String, String> fields) {
        service.updateMovie(id, fields);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable final Long id) {
        service.deleteMovie(id);
        return ResponseEntity.ok().build();
    }
}
