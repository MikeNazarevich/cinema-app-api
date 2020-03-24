package com.mikhail.movieSession;

import com.mikhail.crudBase.BaseSearchService;
import com.mikhail.web.dto.movieSession.MovieSessionDtoIn;

public interface MovieSessionService extends BaseSearchService<MovieSession, MovieSessionFilter> {

    MovieSession addMovieSession(final MovieSession movieSession);

    MovieSession updateMovieSession(final Long id, final MovieSessionDtoIn dtoIn);

    void deleteMovieSession(final Long id);

}
