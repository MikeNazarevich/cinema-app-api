package com.mikhail.web;

import com.mikhail.user.UserService;
import com.mikhail.web.dto.user.UserFullInfoDtoOut;
import com.mikhail.web.dto.user.UserLiteDtoOut;
import com.mikhail.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper mapper;

    @GetMapping("/users/{id}")
    public UserFullInfoDtoOut findById(@PathVariable final Long id) {
        return mapper.toOutFull(userService.findOneOrThrow(id));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserLiteDtoOut>> findAllUsers() {
        return ResponseEntity.ok().body(mapper.toOut(userService.findAll()));
    }
}
