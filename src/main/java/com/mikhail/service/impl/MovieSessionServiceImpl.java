package com.mikhail.service.impl;

import com.mikhail.dto.movieSession.MovieSessionDtoIn;
import com.mikhail.dto.movieSession.MovieSessionDtoOut;
import com.mikhail.mapper.MovieSessionMapper;
import com.mikhail.model.MovieSession;
import com.mikhail.repository.MovieSessionRepository;
import com.mikhail.service.api.MovieSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public MovieSessionDtoOut findById(Long id) {
        MovieSession movieSession = repository.getOne(id);
        return mapper.toOut(movieSession);
    }

    public List<MovieSessionDtoOut> findAll() {
        return mapper.toOut(repository.findAll());
    }


}
