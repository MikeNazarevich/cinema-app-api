package com.mikhail.web.dto.movie;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieFullInfoDtoOut {

    private String name;
    private String producer;
    private String description;
    private Integer releaseYear;
//    private String url;
}
