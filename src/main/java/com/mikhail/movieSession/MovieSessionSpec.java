package com.mikhail.movieSession;

import com.mikhail.movieSession.impl.MovieSession;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;

public class MovieSessionSpec implements Specification<MovieSession> {

    @Override
    public Predicate toPredicate(Root<MovieSession> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }

    public static Specification<MovieSession> findByMovieDateBetween(LocalDateTime dateFrom, LocalDateTime dateTo) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("movieDate"), dateFrom, dateTo);
    }
}
