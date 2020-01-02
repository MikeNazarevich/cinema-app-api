package com.mikhail.ticket;

import com.mikhail.ticket.impl.Ticket;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;

public class TicketSpec implements Specification<Ticket> {
    @Override
    public Predicate toPredicate(Root<Ticket> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }

    public static Specification<Ticket> findByDate(LocalDateTime dateFrom, LocalDateTime dateTo) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.and(
                criteriaBuilder.between(root.join("movieSession").get("movieDate"), dateFrom, dateTo);
        )
    }
}
