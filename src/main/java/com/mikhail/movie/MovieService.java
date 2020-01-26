package com.mikhail.movie;

import com.mikhail.crudBase.BaseSearchService;
import com.mikhail.web.dto.movie.MovieDtoIn;

public interface MovieService extends BaseSearchService<Movie, MovieFilter> {

    void addMovie(final Movie movie);

    void updateMovie(final Long id, final MovieDtoIn dtoIn);

    void deleteMovie(Long id);

}
