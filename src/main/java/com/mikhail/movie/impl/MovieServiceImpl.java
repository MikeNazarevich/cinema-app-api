package com.mikhail.movie.impl;

import com.mikhail.crudBase.BaseSearchServiceImpl;
import com.mikhail.movie.MovieFilter;
import com.mikhail.movie.MovieService;
import com.mikhail.movie.MovieSpec;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Service
//@RequiredArgsConstructor
public class MovieServiceImpl extends BaseSearchServiceImpl<Movie, MovieFilter, MovieSpec, MovieRepository>
        implements MovieService {

//    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository repository, MovieSpec spec) {
        super(repository, spec);
    }


    public void addMovie(Movie movie) {
        repository.save(movie);
    }

    public void updateMovie(final Long id, final Map<String, String> fields) {
        Movie movie = findOneOrThrow(id);

        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(Movie.class, k);

            if (field != null)
                ReflectionUtils.setField(field, movie, v);
        });
        movieRepository.save(movie);
    }

    public void deleteMovie(final Long id) {
        movieRepository.deleteById(id);
    }


}
