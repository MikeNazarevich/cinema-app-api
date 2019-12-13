package com.mikhail.mapper;

import com.mikhail.MovieDto;
import com.mikhail.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(source = "id", target = "movieId")
    MovieDto fromJpa (Movie movie);
}
