package com.mikhail.ticket;

import com.mikhail.crudBase.BaseSpec;
import com.mikhail.ticket.impl.Ticket;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class TicketSpec extends BaseSpec<Ticket, TicketFilter> {

    @Override
    protected void addSelfPredicatesToList(TicketFilter filter, Root<Ticket> root, CriteriaQuery<?> query, CriteriaBuilder cb, List<Predicate> predicates) {

    }
}
