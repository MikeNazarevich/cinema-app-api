package com.mikhail.movieSession.impl;

import com.mikhail.crudBase.BaseSpec;
import com.mikhail.movieSession.MovieSession;
import com.mikhail.movieSession.MovieSessionFilter;
import com.mikhail.movieSession.MovieSession_;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class MovieSessionSpec extends BaseSpec<MovieSession, MovieSessionFilter> {

    @Override
    protected void addSelfPredicatesToList(MovieSessionFilter filter, Root<MovieSession> root, CriteriaQuery<?> query, CriteriaBuilder cb, List<Predicate> predicates) {

        addIfNotNull(predicates, filter.getMovieDateFrom(),
                () -> cb.greaterThanOrEqualTo(root.get(MovieSession_.movieDate), filter.getMovieDateFrom()));

        addIfNotNull(predicates, filter.getMovieDateTo(),
                () -> cb.lessThanOrEqualTo(root.get(MovieSession_.movieDate), filter.getMovieDateTo()));
    }
}