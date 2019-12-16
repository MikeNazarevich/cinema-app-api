package com.mikhail.mapper;

import java.util.List;

public interface DtoMapper<IN, OUT, T> {

    OUT toOut(T t);

    T fromIn(IN in);

    List<OUT> toOut(List<T> tList);

    List<T> fromIn(List<IN> inList);
}
