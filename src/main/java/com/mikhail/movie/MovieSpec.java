package com.mikhail.movie;

import com.mikhail.movie.impl.Movie;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.Year;

public class MovieSpec implements Specification<Movie> {

    @Override
    public Predicate toPredicate(Root<Movie> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }


    public static Specification<Movie> findByName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name);
    }

    public static Specification<Movie> findByReleaseYearBetween(Year yearFrom, Year yearTo) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("year"), yearFrom, yearTo);
    }
}
