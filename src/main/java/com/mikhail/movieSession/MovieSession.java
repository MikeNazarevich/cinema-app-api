package com.mikhail.movieSession;

import com.mikhail.crudBase.BaseEntity;
import com.mikhail.movie.Movie;
import com.mikhail.ticket.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "movie_session")
@Entity
public class MovieSession extends BaseEntity {

    @Column(name = "movie_date")
    private LocalDateTime movieDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToMany(
            mappedBy = "movieSession",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Ticket> tickets;
}
