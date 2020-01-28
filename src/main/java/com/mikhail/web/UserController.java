package com.mikhail.web;

import com.mikhail.user.UserService;
import com.mikhail.web.dto.user.UserFullInfoDtoOut;
import com.mikhail.web.dto.user.UserLiteDtoOut;
import com.mikhail.web.dto.user.UserRegInfoDtoIn;
import com.mikhail.web.dto.user.UserUpdateInfo;
import com.mikhail.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping(value = "/user/register")
    public ResponseEntity<Void> registerUser(@RequestBody @Valid final UserRegInfoDtoIn regInfoDtoIn) {
        userService.registerUser(mapper.fromIn(regInfoDtoIn));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable final Long id,
                                           @RequestBody @Valid final UserUpdateInfo updateInfo) {
        userService.updateUser(id, updateInfo);
        return ResponseEntity.ok().build();
    }
}
