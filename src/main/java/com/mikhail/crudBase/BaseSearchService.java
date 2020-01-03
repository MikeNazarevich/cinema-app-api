package com.mikhail.crudBase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BaseSearchService<
        E extends BaseEntity,
        F extends BaseEntityFilter> {

    Page<E> findAllPage(Pageable page);

    Page<E> findAllPage(F filter, Pageable page);

    List<E> findAll();

    List<E> findAll(F filter);

    Optional<E> findOne(Long id);

    E findOneOrThrow(Long id);
}
