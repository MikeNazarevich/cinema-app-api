package com.mikhail.movie;

import com.mikhail.crudBase.BaseSearchService;
import com.mikhail.web.dto.movie.MovieDtoIn;

public interface MovieService extends BaseSearchService<Movie, MovieFilter> {

    Movie addMovie(final Movie movie);

    Movie updateMovie(final Long id, final MovieDtoIn dtoIn);

    void deleteMovie(Long id);

}
