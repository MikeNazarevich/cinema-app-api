package com.mikhail.user;

import com.mikhail.crudBase.BaseSearchService;
import com.mikhail.user.impl.User;

import java.util.Map;

public interface UserService extends BaseSearchService<User, UserFilter> {

    void registerUser(final User user);

    void deleteUserById(final Long id);

    void updateUser(final Long id, final Map<String, String> user);

}
