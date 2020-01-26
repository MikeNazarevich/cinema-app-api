package com.mikhail.movieSession.impl;

import com.mikhail.crudBase.BaseSearchServiceImpl;
import com.mikhail.movieSession.MovieSession;
import com.mikhail.movieSession.MovieSessionFilter;
import com.mikhail.movieSession.MovieSessionService;
import com.mikhail.web.dto.movie.MovieDtoIn;
import org.springframework.stereotype.Service;

//TODO add logic to methods
@Service
public class MovieSessionServiceImpl extends BaseSearchServiceImpl<MovieSession, MovieSessionFilter, MovieSessionSpec, MovieSessionRepository>
        implements MovieSessionService {

    public MovieSessionServiceImpl(MovieSessionRepository repository, MovieSessionSpec spec) {
        super(repository, spec);
    }

    @Override
    public void addMovieSession(MovieSession movieSession) {

    }

    @Override
    public void updateMovieSession(Long id, MovieDtoIn dtoIn) {

    }

    @Override
    public void deleteMovieSession(Long id) {

    }
}
