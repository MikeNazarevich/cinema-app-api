package com.mikhail.movie.impl;

import com.mikhail.crudBase.BaseSearchServiceImpl;
import com.mikhail.movie.Movie;
import com.mikhail.movie.MovieFilter;
import com.mikhail.movie.MovieService;
import com.mikhail.movieFile.MovieFileService;
import com.mikhail.web.dto.movie.MovieDtoIn;
import com.mikhail.web.mapper.MovieMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class MovieServiceImpl extends
        BaseSearchServiceImpl<Movie, MovieFilter, MovieSpec, MovieRepository>
        implements MovieService {

    private final MovieMapper mapper;
    private final MovieFileService movieFileService;

    public MovieServiceImpl(MovieRepository repository, MovieFileService movieFileService, MovieSpec spec, MovieMapper mapper) {
        super(repository, spec);
        this.mapper = mapper;
        this.movieFileService = movieFileService;
    }

    @Transactional
    public Movie addMovie(final Movie movie, Optional<MultipartFile> image) {
        String url = image.map(file -> movieFileService.addMovieFile(file).getUrl()).orElse(null);
        movie.setUrl(url);

        return getRepository().save(movie);
    }

    @Transactional
    public Movie updateMovie(final Long id, final MovieDtoIn dtoIn, Optional<MultipartFile> image) {
        Movie movie = findOneOrThrow(id);

        if (!image.isPresent()) {
            movieFileService.deleteMovieFile(movie.getUrl());
            movie.setUrl(null);
        } else {
            String url = movieFileService.updateMovieFile(movie.getUrl(), image.get()).getUrl();
            movie.setUrl(url);
        }

        mapper.merge(dtoIn, movie);
        return movie;
    }

    @Transactional
    public void deleteMovie(final Long id) {
        Movie movie = findOneOrThrow(id);
        movieFileService.deleteMovieFile(movie.getUrl());

        getRepository().deleteById(id);
    }

}
