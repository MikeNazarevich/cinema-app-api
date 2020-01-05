package com.mikhail.web;

import com.mikhail.movieSession.MovieSessionFilter;
import com.mikhail.movieSession.MovieSessionService;
import com.mikhail.web.dto.movieSession.MovieSessionDtoOut;
import com.mikhail.web.mapper.MovieSessionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MovieSessionController {

    private final MovieSessionService service;
    private final MovieSessionMapper mapper;

    @GetMapping("/sessions")
    public ResponseEntity<Page<MovieSessionDtoOut>> findAll(MovieSessionFilter filter, Pageable page) {
        return ResponseEntity.ok().body(mapper.toOut(service.findAllPage(filter, page)));
    }


}
