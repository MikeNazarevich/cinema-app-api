package com.mikhail.movieSession.impl;

import com.mikhail.crudBase.BaseSearchServiceImpl;
import com.mikhail.movieSession.MovieSession;
import com.mikhail.movieSession.MovieSessionFilter;
import com.mikhail.movieSession.MovieSessionService;
import com.mikhail.web.dto.movieSession.MovieSessionDtoIn;
import com.mikhail.web.mapper.MovieSessionMapper;
import org.springframework.stereotype.Service;

//TODO add logic to methods
@Service
public class MovieSessionServiceImpl
        extends BaseSearchServiceImpl<MovieSession, MovieSessionFilter, MovieSessionSpec, MovieSessionRepository>
        implements MovieSessionService {

    private final MovieSessionMapper mapper;

    public MovieSessionServiceImpl(MovieSessionRepository repository, MovieSessionSpec spec, MovieSessionMapper mapper) {
        super(repository, spec);
        this.mapper = mapper;
    }

    @Override
    public MovieSession addMovieSession(final MovieSession movieSession) {
        return getRepository().save(movieSession);
    }

    @Override
    public MovieSession updateMovieSession(final Long id, final MovieSessionDtoIn dtoIn) {
        MovieSession movieSession = findOneOrThrow(id);

        mapper.merge(dtoIn, movieSession);
        return getRepository().save(movieSession);
    }

    @Override
    public void deleteMovieSession(final Long id) {
        getRepository().deleteById(id);
    }

}
