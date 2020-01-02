package com.mikhail.user;

import com.mikhail.user.impl.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    User findUserById(final Long id);

    List<User> findAll();

    void registerUser(final User user);

    void deleteUserById(final Long id);

    void updateUser(final Long id, final Map<String, String> user);

}
