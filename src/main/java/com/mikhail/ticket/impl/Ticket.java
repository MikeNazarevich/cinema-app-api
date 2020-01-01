package com.mikhail.ticket.impl;

import com.mikhail.crudBase.BaseEntity;
import com.mikhail.movieSession.impl.MovieSession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "ticket")
@Entity
public class Ticket extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_session_id")
    private MovieSession movieSession;

    private Long row;

    private Long place;
}
