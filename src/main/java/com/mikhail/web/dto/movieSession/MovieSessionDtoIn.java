package com.mikhail.web.dto.movieSession;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieSessionDtoIn {

    private LocalDateTime movieDate;

    private Long movieId;

}
