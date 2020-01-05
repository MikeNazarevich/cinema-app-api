package com.mikhail.ticket.impl;

import com.mikhail.crudBase.BaseEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends BaseEntityRepository<Ticket> {
}
