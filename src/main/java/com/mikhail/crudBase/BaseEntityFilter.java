package com.mikhail.crudBase;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public abstract class BaseEntityFilter {

    private List<Long> id;
    private Instant createdTo;
    private Instant createdFrom;
    private Instant updatedTo;
    private Instant updatedFrom;
    private List<Long> updatedBy;
    private List<Long> createdBy;
}
