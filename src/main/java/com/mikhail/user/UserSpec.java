package com.mikhail.user;

import com.mikhail.crudBase.BaseSpec;
import com.mikhail.user.impl.User;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class UserSpec extends BaseSpec<User, UserFilter> {

    @Override
    protected void addSelfPredicatesToList(UserFilter filter, Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb, List<Predicate> predicates) {

    }
}
