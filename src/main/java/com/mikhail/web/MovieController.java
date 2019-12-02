package com.mikhail.web;

import com.mikhail.movie.MovieService;
import com.mikhail.web.dto.movie.MovieDtoIn;
import com.mikhail.web.dto.movie.MovieFullInfoDtoOut;
import com.mikhail.web.dto.movie.MovieShortInfoDtoOut;
import com.mikhail.web.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService service;
    private final MovieMapper mapper;

    @GetMapping
    public ResponseEntity<Page<MovieShortInfoDtoOut>> findAllMoviesPage(Pageable page) {
        return ResponseEntity.ok().body(mapper.toOut(service.findAllPage(page)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieFullInfoDtoOut> findMovie(@PathVariable final Long id) {
        return ResponseEntity.ok().body(mapper.ToFullOut(service.findOneOrThrow(id)));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MovieFullInfoDtoOut> addMovie(@RequestPart(required = false) Optional<MultipartFile> image, @RequestPart @Valid final MovieDtoIn dtoIn) {
        return ResponseEntity.ok().body(mapper.ToFullOut(service.addMovie(mapper.fromIn(dtoIn), image)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieFullInfoDtoOut> updateMovie(@PathVariable final Long id, @RequestPart @Valid final MovieDtoIn dtoIn,
                                                           @RequestPart(required = false) Optional<MultipartFile> image) {
        return ResponseEntity.ok().body(mapper.ToFullOut(service.updateMovie(id, dtoIn, image)));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteMovie(@PathVariable final Long id) {
        service.deleteMovie(id);
        return ResponseEntity.ok().build();
    }
}
