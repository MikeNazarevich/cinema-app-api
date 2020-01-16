package com.mikhail.movieSession.impl;

import com.mikhail.crudBase.BaseSearchServiceImpl;
import com.mikhail.movieSession.MovieSessionFilter;
import com.mikhail.movieSession.MovieSessionService;
import com.mikhail.movieSession.MovieSessionSpec;
import org.springframework.stereotype.Service;

@Service
public class MovieSessionServiceImpl extends BaseSearchServiceImpl<MovieSession, MovieSessionFilter, MovieSessionSpec, MovieSessionRepository>
        implements MovieSessionService {

    public MovieSessionServiceImpl(MovieSessionRepository repository, MovieSessionSpec spec) {
        super(repository, spec);
    }

}
