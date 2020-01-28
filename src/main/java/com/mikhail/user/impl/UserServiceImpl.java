package com.mikhail.user.impl;

import com.mikhail.crudBase.BaseSearchServiceImpl;
import com.mikhail.user.User;
import com.mikhail.user.UserFilter;
import com.mikhail.user.UserService;
import com.mikhail.web.dto.user.UserUpdateInfo;
import com.mikhail.web.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseSearchServiceImpl<User, UserFilter, UserSpec, UserRepository>
        implements UserService {

    private final UserMapper mapper;

    public UserServiceImpl(UserRepository repository, UserSpec spec, UserMapper mapper) {
        super(repository, spec);
        this.mapper = mapper;
    }

    public void registerUser(final User user) {
        getRepository().save(user);
    }

    public void updateUser(Long id, UserUpdateInfo updateInfo) {
        User user = findOneOrThrow(id);
        mapper.merge(updateInfo, user);

        getRepository().save(user);
    }
}
