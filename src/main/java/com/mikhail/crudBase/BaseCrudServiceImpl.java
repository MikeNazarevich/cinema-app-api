package com.mikhail.crudBase;

//TODO fix methods
public abstract class BaseCrudServiceImpl<
        E extends BaseEntity,
        R extends BaseEntityRepository<E>> implements BaseCrudService<E> {

    private final R repository;

    protected BaseCrudServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public void update(Long id, E entity) {
        E findEntity = repository.getOne(id);
        repository.save(findEntity);
    }

    @Override
    public void create(E entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
