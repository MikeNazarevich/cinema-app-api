package com.mikhail.movie;

import com.mikhail.crudBase.BaseEntity;
import com.mikhail.movieSession.MovieSession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "movie")
@Entity
public class Movie extends BaseEntity {

    @Size(max = 100)
    @NotBlank
    @Column(nullable = false)
    private String name;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Size(max = 100)
    @Column(length = 100)
    private String producer;

    @Lob
    @Size(max = 8192)
    @Type(type = "org.hibernate.type.TextType")
    @Column(length = 8192)
    private String description;

    @OneToMany(mappedBy = "movie",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<MovieSession> movieSession;
}
