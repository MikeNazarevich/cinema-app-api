package com.mikhail.controller;

import com.mikhail.dto.user.UserFullInfoDtoOut;
import com.mikhail.dto.user.UserLiteDtoOut;
import com.mikhail.dto.user.UserRegInfoDtoIn;
import com.mikhail.dto.user.UserUpdateInfo;
import com.mikhail.service.impl.UserService;
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

    @GetMapping("/users/{id}")
    public UserFullInfoDtoOut findById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserLiteDtoOut>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAll());
    }

    @PostMapping(value = "/user/register")
    public ResponseEntity<Void> registerUser(@Valid UserRegInfoDtoIn regInfoDtoIn) {
        userService.registerUser(regInfoDtoIn);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id,
                                           @RequestBody @Valid UserUpdateInfo updateInfo) {
        userService.updateUser(id, updateInfo);
        return ResponseEntity.ok().build();
    }
}
