package com.mikhail.web;

import com.mikhail.movie.MovieSpec;
import com.mikhail.movie.impl.Movie;
import com.mikhail.movie.impl.MovieService;
import com.mikhail.web.dto.movie.MovieDtoIn;
import com.mikhail.web.dto.movie.MovieDtoOut;
import com.mikhail.web.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper mapper;

    @GetMapping(value = "/movies")
    public ResponseEntity<List<MovieDtoOut>> getAllMovies() {
        return ResponseEntity.ok().body(mapper.toOut(movieService.findAllMovies()));
    }

    public ResponseEntity<Page<MovieDtoOut>> getMovies(MovieSpec spec, Pageable page) {
        return ResponseEntity.ok().body(mapper.toOut(movieService.findAll(spec, page)));
    }

    @GetMapping(value = "/movies/{id}")
    public ResponseEntity<MovieDtoOut> getMovie(@PathVariable(name = "id") final Long movieId) {
        return ResponseEntity.ok().body(mapper.toOut(movieService.findMovie(movieId)));
    }

    @PostMapping("/movies")
    public ResponseEntity<Void> addMovie(
            @RequestBody @Valid MovieDtoIn dtoIn) {
        movieService.addMovie(mapper.fromIn(dtoIn));
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/movies/{id}")
    public ResponseEntity<Void> updateMovie(@PathVariable final Long id, @RequestBody @Valid final MovieDtoIn dtoIn) {
        Movie movie = mapper.fromIn(dtoIn);
        movie.setId(id);
        movieService.updateMovie(movie);
        return ResponseEntity.ok().build();
    }
}
