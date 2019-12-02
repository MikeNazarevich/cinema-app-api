package com.mikhail.movieSession;

import com.mikhail.crudBase.BaseEntityFilter;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class MovieSessionFilter extends BaseEntityFilter {

    private Instant movieDateFrom;
    private Instant movieDateTo;
}
