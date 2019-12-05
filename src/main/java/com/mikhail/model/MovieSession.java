package com.mikhail.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "movie_session")
@Entity
public class MovieSession extends UpdatedInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_date")
    private LocalDateTime movieDate;

    @OneToOne(mappedBy = "movie_session")
    private Movie movie;
}
