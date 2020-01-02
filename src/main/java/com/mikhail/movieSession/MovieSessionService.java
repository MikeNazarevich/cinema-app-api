package com.mikhail.movieSession;

import com.mikhail.movieSession.impl.MovieSession;
import com.mikhail.web.dto.movieSession.MovieSessionDtoIn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieSessionService {

    void addMovieSession(final MovieSessionDtoIn dtoIn);

    MovieSession findById(final Long id);

    Page<MovieSession> findAll(MovieSessionSpec spec, Pageable pageable);
}
