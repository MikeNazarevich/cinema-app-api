package com.mikhail.web;

import com.mikhail.movieSession.impl.MovieSessionServiceImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieSessionController {

    private final MovieSessionServiceImpl service;

    public MovieSessionController(MovieSessionServiceImpl service) {
        this.service = service;
    }


}
