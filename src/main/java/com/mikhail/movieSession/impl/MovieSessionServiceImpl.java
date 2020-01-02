package com.mikhail.movieSession.impl;

import com.mikhail.movieSession.MovieSessionService;
import com.mikhail.movieSession.MovieSessionSpec;
import com.mikhail.web.dto.movieSession.MovieSessionDtoIn;
import com.mikhail.web.mapper.MovieSessionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieSessionServiceImpl implements MovieSessionService {

    private final MovieSessionMapper mapper;
    private final MovieSessionRepository repository;

    public void addMovieSession(MovieSessionDtoIn dtoIn) {
        MovieSession movieSession = new MovieSession();
        mapper.merge(dtoIn, movieSession);
        repository.save(movieSession);
    }

    public MovieSession findById(Long id) {
        return repository.getOne(id);
    }

    public Page<MovieSession> findAll(MovieSessionSpec spec, Pageable page) {
        return repository.findAll(spec, page);
    }


}
