package com.mikhail.user.impl;

import com.mikhail.crudBase.BaseSearchServiceImpl;
import com.mikhail.user.User;
import com.mikhail.user.UserFilter;
import com.mikhail.user.UserService;
import com.mikhail.web.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends BaseSearchServiceImpl<User, UserFilter, UserSpec, UserRepository>
        implements UserService {

    private final UserMapper mapper;

    public UserServiceImpl(UserRepository repository, UserSpec spec, UserMapper mapper) {
        super(repository, spec);
        this.mapper = mapper;
    }

    @Override
    public User saveUser(final User user) {
        Optional.of(findByEmail(user.getEmail())) ;
        return getRepository().save(user);
    }

    @Override
    public Optional<User> findByIamId(String iamId) {
        return getRepository().findByIamId(iamId);
    }

    public Optional<User> findByEmail(String email) {
        return getRepository().findByEmail(email);
    }

    public UserMapper getMapper() {
        return mapper;
    }
}
