package com.mikhail.crudBase;

import org.springframework.data.domain.Page;

import java.util.List;

public interface DtoMapper<IN, OUT, T> {

    OUT toOut(T t);

    T fromIn(IN in);

    List<OUT> toOut(Iterable<T> tList);

    default Page<OUT> toOut(Page<T> page) {
        return page.map(this::toOut);
    }

    List<T> fromIn(List<IN> inList);
}
