package com.mikhail.movie.impl;

import com.mikhail.crudBase.BaseSearchServiceImpl;
import com.mikhail.movie.Movie;
import com.mikhail.movie.MovieFilter;
import com.mikhail.movie.MovieService;
import com.mikhail.web.dto.movie.MovieDtoIn;
import com.mikhail.web.mapper.MovieMapper;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl extends
        BaseSearchServiceImpl<Movie, MovieFilter, MovieSpec, MovieRepository>
        implements MovieService {

    private final MovieMapper mapper;

    public MovieServiceImpl(MovieRepository repository, MovieSpec spec, MovieMapper mapper) {
        super(repository, spec);
        this.mapper = mapper;
    }

    public Movie addMovie(final Movie movie) {
        return getRepository().save(movie);
    }

    public Movie updateMovie(final Long id, final MovieDtoIn dtoIn) {
        Movie movie = findOneOrThrow(id);

        mapper.merge(dtoIn, movie);
        return getRepository().save(movie);
    }

    public void deleteMovie(final Long id) {
        getRepository().deleteById(id);
    }

}
