package com.mikhail.user.impl;

import com.mikhail.crudBase.BaseEntityRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseEntityRepository<User> {

    Optional<User> findByEmail(String email);
}
