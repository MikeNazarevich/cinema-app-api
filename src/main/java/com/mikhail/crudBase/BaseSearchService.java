package com.mikhail.crudBase;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BaseSearchService<
        E extends BaseEntity,
        F extends BaseEntityFilter> {

    Page<E> findAllPage(Pageable page);

    Page<E> findAllPage(F filter, Pageable page);

    Page<E> findAllPage(Pageable pageable, EntityGraph entityGraph);

    Page<E> findAllPage(F filter, Pageable pageable, EntityGraph entityGraph);

    List<E> findAll();

    List<E> findAll(F filter);

    Iterable<E> findAll(F filter, EntityGraph entityGraph);

    Iterable<E> findAll(EntityGraph entityGraph);

    Optional<E> findOne(Long id);

    Optional<E> findOne(Long id, EntityGraph entityGraph);

    Optional<E> findOne(F filter);

    Optional<E> findOne(F filter, EntityGraph entityGraph);

    E getOne(Long id);

    E findOneOrThrow(Long id);

    E findOneOrThrow(Long id, EntityGraph entityGraph);

    E findOneOrThrow(F filter);

    E findOneOrThrow(F filter, EntityGraph entityGraph);
}
