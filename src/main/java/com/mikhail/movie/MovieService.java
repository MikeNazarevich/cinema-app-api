package com.mikhail.movie;

import com.mikhail.crudBase.BaseSearchService;

import java.util.Map;

public interface MovieService extends BaseSearchService<Movie, MovieFilter> {

    void addMovie(Movie movie);

    void updateMovie(Long id, Map<String, String> fields);

    void deleteMovie(Long id);

}
