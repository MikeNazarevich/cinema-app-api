package com.mikhail.movieFile.impl;

import com.mikhail.movieFile.MovieFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieFileRepository extends JpaRepository<MovieFile, Long> {

    MovieFile findByUrl(String url);

    Optional<MovieFile> findByFilePath(String path);
}
