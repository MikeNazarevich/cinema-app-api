package com.mikhail.user.impl;

import com.mikhail.crudBase.BaseSearchServiceImpl;
import com.mikhail.user.User;
import com.mikhail.user.UserFilter;
import com.mikhail.user.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseSearchServiceImpl<User, UserFilter, UserSpec, UserRepository>
        implements UserService {


    public UserServiceImpl(UserRepository repository, UserSpec spec) {
        super(repository, spec);
    }

    public void registerUser(final User user) {
        getRepository().save(user);
    }

    public void deleteUserById(Long id) {
        getRepository().deleteById(id);
    }

    public void updateUser(Long id, Map<String, String> fields) {
        User user = findOneOrThrow(id);

        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(User.class, k);

            if (field != null)
                ReflectionUtils.setField(field, user, v);
        });
        getRepository().save(user);
    }
}
