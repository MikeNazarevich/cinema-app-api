package com.mikhail.movieSession;

import com.mikhail.crudBase.BaseSearchService;
import com.mikhail.web.dto.movie.MovieDtoIn;

public interface MovieSessionService extends BaseSearchService<MovieSession, MovieSessionFilter> {

    void addMovieSession(final MovieSession movieSession);

    void updateMovieSession(final Long id, final MovieDtoIn dtoIn);

    void deleteMovieSession(final Long id);

}
