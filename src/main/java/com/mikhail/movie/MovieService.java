package com.mikhail.movie;

import com.mikhail.crudBase.BaseSearchService;
import com.mikhail.web.dto.movie.MovieDtoIn;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface MovieService extends BaseSearchService<Movie, MovieFilter> {

    Movie addMovie(final Movie movie, Optional<MultipartFile> movieAvatar);

    Movie updateMovie(final Long id, final MovieDtoIn dtoIn, Optional<MultipartFile> file);

    void deleteMovie(Long id);

}
