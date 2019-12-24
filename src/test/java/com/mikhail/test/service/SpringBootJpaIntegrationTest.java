package com.mikhail.test.service;

import com.mikhail.Application;
import com.mikhail.dto.user.UserRegInfoDtoIn;
import com.mikhail.mapper.UserMapper;
import com.mikhail.model.User;
import com.mikhail.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = Application.class)
public class SpringBootJpaIntegrationTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void givenUserEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
        UserRegInfoDtoIn infoDtoIn = UserRegInfoDtoIn.builder()
                .name("mike")
                .surname("que")
                .email("ewqe@mail.ru")
                .password("qwerty123")
                .build();
        User user = new User();
        userMapper.merge(infoDtoIn, user);
        User newUser = userRepository.save(user);

        Optional<User> foundUser = userRepository.findById(newUser.getId());
        assertNotNull(foundUser);
        assertEquals(user, foundUser);
    }

    @Test
    public void testAdd() {
        assertEquals(42, Integer.sum(19, 23));
    }
}
