package com.mikhail.web.dto.movieSession;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieSessionDtoIn {

    @NotBlank
    private LocalDateTime movieDate;

    @NotBlank
    private Long movieId;

}
