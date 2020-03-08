package com.mikhail.movieSession;

import com.mikhail.crudBase.BaseEntity;
import com.mikhail.movie.Movie;
import com.mikhail.ticket.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "movie_session")
@Entity
@NamedEntityGraph(
        name = "Session.movie",
        attributeNodes = @NamedAttributeNode("movie")
)
@NamedEntityGraph(
        name = "Session.tickets",
        attributeNodes = @NamedAttributeNode("tickets")
)
@NamedEntityGraph(
        name = "Session.all",
        attributeNodes = {
                @NamedAttributeNode("movie"),
                @NamedAttributeNode("tickets")
        }
)
public class MovieSession extends BaseEntity {

    @Column(name = "movie_date")
    private Instant movieDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToMany(
            mappedBy = "movieSession",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Ticket> tickets;
}
