package com.mikhail.user;

import com.mikhail.crudBase.BaseSearchService;

import java.util.Optional;

public interface UserService extends BaseSearchService<User, UserFilter> {

    User saveUser(final User user);

    Optional<User> findByIamId(final String iamId);

}
