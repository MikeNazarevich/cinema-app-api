package com.mikhail.crudBase;


import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseEntityRepository<T extends BaseEntity>
        extends EntityGraphJpaRepository<T, Long>, EntityGraphJpaSpecificationExecutor<T> {
}
