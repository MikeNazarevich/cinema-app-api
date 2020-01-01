package com.mikhail.movieSession;

import com.mikhail.web.dto.movieSession.MovieSessionDtoIn;
import com.mikhail.web.dto.movieSession.MovieSessionDtoOut;

import java.util.List;

public interface MovieSessionService {

    void addMovieSession(final MovieSessionDtoIn dtoIn);

    MovieSessionDtoOut findById(final Long id);

    List<MovieSessionDtoOut> findAll();
}
