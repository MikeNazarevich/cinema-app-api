package com.mikhail.crudBase;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraph;
import com.mikhail.crudBase.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

public abstract class BaseSearchServiceImpl<
        E extends BaseEntity,
        F extends BaseEntityFilter,
        S extends BaseSpec<E, F>,
        R extends BaseEntityRepository<E>> implements BaseSearchService<E, F> {

    private final R repository;
    private final S spec;

    private Class<E> persistentClass;

    public BaseSearchServiceImpl(R repository, S spec) {
        this.repository = repository;
        this.spec = spec;

        this.persistentClass = (Class<E>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public R getRepository() {
        return repository;
    }

    public S getSpec() {
        return spec;
    }

    @Override
    public Page<E> findAllPage(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Page<E> findAllPage(F filter, Pageable page) {
        Specification<E> specification = spec.build(filter);
        return repository.findAll(specification, page);
    }

    @Override
    public Page<E> findAllPage(Pageable pageable, EntityGraph entityGraph) {
        return repository.findAll(pageable, entityGraph);
    }

    @Override
    public Page<E> findAllPage(F filter, Pageable pageable, EntityGraph graph) {
        Specification<E> specification = spec.build(filter);
        return repository.findAll(specification, pageable, graph);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public List<E> findAll(F filter) {
        Specification<E> specification = spec.build(filter);
        return repository.findAll(specification);
    }

    @Override
    public Iterable<E> findAll(F filter, EntityGraph entityGraph) {
        Specification<E> specification = spec.build(filter);
        return repository.findAll(specification, entityGraph);
    }

    @Override
    public Iterable<E> findAll(EntityGraph entityGraph) {
        return repository.findAll(entityGraph);
    }

    @Override
    public Optional<E> findOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<E> findOne(F filter) {
        Specification<E> specification = spec.build(filter);
        return repository.findOne(specification);
    }

    @Override
    public Optional<E> findOne(Long id, EntityGraph entityGraph) {
        return repository.findById(id, entityGraph);
    }

    @Override
    public Optional<E> findOne(F filter, EntityGraph entityGraph) {
        Specification<E> specification = spec.build(filter);
        return repository.findOne(specification, entityGraph);
    }

    @Override
    public E findOneOrThrow(Long id) {
        Optional<E> result = findOne(id);
        if (!result.isPresent()) {
            throw new ResourceNotFoundException(
                    String.format("No %s entity with id %s exists!", persistentClass.getSimpleName(), id));
        }
        return result.get();
    }

    @Override
    public E findOneOrThrow(Long id, EntityGraph entityGraph) {
        Optional<E> result = findOne(id, entityGraph);
        if (!result.isPresent()) {
            throw new ResourceNotFoundException(
                    String.format("No %s entity with id %s exists!", persistentClass.getSimpleName(), id));
        }
        return result.get();
    }

    @Override
    public E findOneOrThrow(F filter) {
        Optional<E> result = findOne(filter);
        if (!result.isPresent()) {
            throw new ResourceNotFoundException(
                    String.format("Resource %s not found by filter %s", persistentClass.getSimpleName(), filter));
        }
        return result.get();
    }

    @Override
    public E findOneOrThrow(F filter, EntityGraph entityGraph) {
        Optional<E> result = findOne(filter, entityGraph);
        if (!result.isPresent()) {
            throw new ResourceNotFoundException(
                    String.format("Resource %s not found by filter %s", persistentClass.getSimpleName(), filter));
        }
        return result.get();
    }
}
