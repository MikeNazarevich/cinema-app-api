package com.mikhail.movieSession;

import com.mikhail.crudBase.BaseSpec;
import com.mikhail.movieSession.impl.MovieSession;
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

    }
}
