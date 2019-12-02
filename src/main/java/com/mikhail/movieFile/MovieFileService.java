package com.mikhail.movieFile;

import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface MovieFileService {

    MovieFile addMovieFile(MultipartFile image);

    MovieFile updateMovieFile(String url, MultipartFile image);

    void deleteMovieFile(String url);

    Optional<MovieFile> findByPath(String path);
}
