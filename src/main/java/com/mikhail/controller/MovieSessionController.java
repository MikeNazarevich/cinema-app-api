package com.mikhail.controller;

import com.mikhail.service.impl.MovieSessionServiceImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieSessionController {

    private final MovieSessionServiceImpl service;

    public MovieSessionController(MovieSessionServiceImpl service) {
        this.service = service;
    }


}
