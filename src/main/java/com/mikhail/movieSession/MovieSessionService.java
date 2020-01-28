package com.mikhail.movieSession;

import com.mikhail.crudBase.BaseSearchService;
import com.mikhail.web.dto.movieSession.MovieSessionDtoIn;

public interface MovieSessionService extends BaseSearchService<MovieSession, MovieSessionFilter> {

    void addMovieSession(final MovieSession movieSession);

    void updateMovieSession(final Long id, final MovieSessionDtoIn dtoIn);

    void deleteMovieSession(final Long id);

}
