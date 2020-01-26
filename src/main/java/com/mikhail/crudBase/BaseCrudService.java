package com.mikhail.crudBase;

public interface BaseCrudService<E extends BaseEntity> {

    void update(final Long id, E entity);

    void create(final E entity);

    void delete(final Long id);
}
