package com.mikhail.ticket;

import com.mikhail.crudBase.BaseEntity;
import com.mikhail.movieSession.MovieSession;
import com.mikhail.user.User;
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
@NamedEntityGraph(
        name = "Ticket.all",
        attributeNodes = {}
)
public class Ticket extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_session_id")
    private MovieSession movieSession;

    private Long row;

    private Long place;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
