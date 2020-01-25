package com.mikhail.user.impl;

import com.mikhail.crudBase.BaseEntityRepository;
import com.mikhail.user.User;

import java.util.Optional;

public interface UserRepository extends BaseEntityRepository<User> {

    Optional<User> findByEmail(String email);
}
