package com.mikhail.user.impl;

import com.mikhail.exceptionHandler.ResourceNotFoundException;
import com.mikhail.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found"));
    }

    public User findUserById(final Long id) {
        return findById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void registerUser(final User user) {
        userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public void updateUser(Long id, Map<String, String> fields) {
        User user = findById(id);

        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(User.class, k);

            if (field != null)
                ReflectionUtils.setField(field, user, v);
        });
        userRepository.save(user);
    }
}
