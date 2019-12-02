package com.mikhail.movieFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
@Table(name = "movie_file")
@Entity
public class MovieFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @NotBlank
    @Column(nullable = false)
    private String name;

    @Size(max = 100)
    @NotBlank
    @Column(name = "file_path", nullable = false)
    private String filePath;

    @NotBlank
    @Column(nullable = false)
    private String url;

//    @NotBlank
    @Column(name = "mime_type", nullable = false)
    private String mimeType;

}
