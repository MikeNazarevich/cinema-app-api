package com.mikhail.user;

import com.mikhail.crudBase.BaseSearchService;
import com.mikhail.web.dto.user.UserUpdateInfo;

import java.util.Optional;

public interface UserService extends BaseSearchService<User, UserFilter> {

    void registerUser(final User user);

    void updateUser(final Long id, final UserUpdateInfo user);

    Optional<User> findByIamId(final String iamId);

}
