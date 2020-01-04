package com.mikhail.crudBase;

import com.mikhail.crudBase.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

public class BaseSearchServiceImpl<
        E extends BaseEntity,
        F extends BaseEntityFilter,
        S extends BaseEntitySpec<E, F>,
        R extends BaseEntityRepository<E>> implements BaseSearchService<E, F> {

    private final R repository;
    private final S spec;

    private Class<E> persistentClass;

    public BaseSearchServiceImpl(R repository, S spec) {
        this.repository = repository;
        this.spec = spec;

        //TODO WHAT?
        this.persistentClass = (Class<E>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
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
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public List<E> findAll(F filter) {
        Specification<E> specification = spec.build(filter);
        return repository.findAll(specification);
    }

    @Override
    public Optional<E> findOne(Long id) {
        return repository.findById(id);
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
}
