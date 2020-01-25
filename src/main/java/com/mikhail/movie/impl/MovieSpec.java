package com.mikhail.movie.impl;

import com.mikhail.crudBase.BaseSpec;
import com.mikhail.movie.Movie;
import com.mikhail.movie.MovieFilter;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class MovieSpec extends BaseSpec<Movie, MovieFilter> {

    @Override
    protected void addSelfPredicatesToList(MovieFilter filter, Root<Movie> root, CriteriaQuery<?> query, CriteriaBuilder cb, List<Predicate> predicates) {

    }
}
