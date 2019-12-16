package com.mikhail.service.impl;

import com.mikhail.dto.user.UserFullInfoDtoOut;
import com.mikhail.dto.user.UserLiteDtoOut;
import com.mikhail.dto.user.UserRegInfoDtoIn;
import com.mikhail.mapper.UserMapper;
import com.mikhail.model.User;
import com.mikhail.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserFullInfoDtoOut findById(Long id) {
        return userMapper.toOutFull(userRepository.findById(id));
    }

    public List<UserLiteDtoOut> getAll() {
        return userMapper.toOut(userRepository.findAll());
    }

    public User addUser(UserRegInfoDtoIn regInfoDtoIn) {
        User user = new User();

        userMapper.fromIn(regInfoDtoIn);
        return userMapper.
    }
}
