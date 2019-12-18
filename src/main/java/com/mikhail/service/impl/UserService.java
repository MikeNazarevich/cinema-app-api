package com.mikhail.service.impl;

import com.mikhail.dto.user.UserFullInfoDtoOut;
import com.mikhail.dto.user.UserLiteDtoOut;
import com.mikhail.dto.user.UserRegInfoDtoIn;
import com.mikhail.dto.user.UserUpdateInfo;
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

    public void registerUser(UserRegInfoDtoIn regInfoDtoIn) {
        User user = new User();
        userMapper.merge(regInfoDtoIn, user);
        userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.delete(userRepository.getOne(id));
    }

    public void updateUser(Long id, UserUpdateInfo updateInfo) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new Exception(String.format("cant find")));
        userMapper.merge(updateInfo, user);
        userRepository.save(user);

    }
}
