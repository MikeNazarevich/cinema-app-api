package com.mikhail.movie;

import com.mikhail.exceptionHandler.ResourceNotFoundException;
import com.mikhail.movie.impl.Movie;
import com.mikhail.movie.impl.MovieRepository;
import com.mikhail.movie.impl.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    private Movie findById(final Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
    }

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public Movie findMovie(final Long id) {
        return movieRepository.getOne(id);
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void updateMovie(final Long id, final Map<String, String> fields) {
        Movie movie = findById(id);

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

    public Page<Movie> findAll(MovieSpec spec, Pageable page) {
        return movieRepository.findAll(spec, page);
    }

}
