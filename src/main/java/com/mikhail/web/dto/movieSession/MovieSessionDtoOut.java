package com.mikhail.web.dto.movieSession;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieSessionDtoOut {

    private Instant movieDate;

    private String movieName;
}
