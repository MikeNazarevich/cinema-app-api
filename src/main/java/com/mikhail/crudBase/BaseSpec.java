package com.mikhail.crudBase;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public abstract class BaseSpec<T extends BaseEntity, F extends BaseEntityFilter> {

    public Specification<T> build(F filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new LinkedList<>();

            addIdsPredicate(filter, root, predicates);

            addPredicatesToList(filter, root, query, cb, predicates);

            return cb.and(toArray(predicates));
        };
    }


    protected void addPredicatesToList(F filter, Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb, List<Predicate> predicates) {

        addIfNotNull(predicates, filter.getUpdatedFrom(),
                () -> cb.greaterThanOrEqualTo(root.get(BaseEntity_.updatedAt), filter.getUpdatedFrom()));

        addIfNotNull(predicates, filter.getUpdatedTo(),
                () -> cb.lessThanOrEqualTo(root.get(BaseEntity_.updatedAt), filter.getUpdatedTo()));

        addIfNotNull(predicates, filter.getUpdatedBy(),
                () -> root.get(BaseEntity_.updatedBy).in(filter.getUpdatedBy()));

        addSelfPredicatesToList(filter, root, query, cb, predicates);
    }

    protected abstract void addSelfPredicatesToList(F filter, Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb, List<Predicate> predicates);


    private void addIdsPredicate(F filter, Root<T> root, List<Predicate> predicates) {
        addIfNotNull(predicates, filter.getId(),
                () -> root.get(BaseEntity_.id).in(filter.getId()));
    }

    /**
     * adds predicate produced by predicateSupplier to predicates if filterValue is not null
     *
     * @param predicates        list of predicates
     * @param filterValue       value to check for non-null
     * @param predicateSupplier supplier function
     */
    protected void addIfNotNull(List<Predicate> predicates, Object filterValue, Supplier<Predicate> predicateSupplier) {
        if (filterValue != null) {
            addToPredicates(predicates, predicateSupplier);
        }
    }

    protected void addToPredicates(List<Predicate> predicates, Supplier<Predicate> predicateSupplier) {
        Predicate p = predicateSupplier.get();
        predicates.add(p);
    }

    protected Predicate[] toArray(List<Predicate> predicates) {
        return predicates.toArray(new Predicate[predicates.size()]);
    }


}
