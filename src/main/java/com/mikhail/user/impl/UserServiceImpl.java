package com.mikhail.user.impl;

import com.mikhail.exceptionHandler.ResourceNotFoundException;
import com.mikhail.user.UserService;
import com.mikhail.web.dto.user.UserFullInfoDtoOut;
import com.mikhail.web.dto.user.UserLiteDtoOut;
import com.mikhail.web.dto.user.UserRegInfoDtoIn;
import com.mikhail.web.dto.user.UserUpdateInfo;
import com.mikhail.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found"));
    }

    public UserFullInfoDtoOut findUserById(final Long id) {
        return userMapper.toOutFull(findById(id));
    }

    public List<UserLiteDtoOut> getAll() {
        return userMapper.toOut(userRepository.findAll());
    }

    public void registerUser(final UserRegInfoDtoIn regInfoDtoIn) {
        User user = new User();
        userMapper.merge(regInfoDtoIn, user);
        userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.delete(userRepository.getOne(id));
    }

    public void updateUser(Long id, UserUpdateInfo updateInfo) {
        User user = findById(id);
        userMapper.merge(updateInfo, user);
        userRepository.save(user);

    }
}
