package com.mikhail.movie.impl;

import com.mikhail.crudBase.BaseEntity;
import com.mikhail.movieSession.impl.MovieSession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.Year;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "movie")
@Entity
public class Movie extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Year releaseYear;

    @Size(max = 100)
    private String producer;

    @Size(max = 150)
    private String description;

    @OneToMany(mappedBy = "movie",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<MovieSession> movieSession;
}
