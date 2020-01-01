package com.mikhail.user;

import com.mikhail.web.dto.user.UserFullInfoDtoOut;
import com.mikhail.web.dto.user.UserLiteDtoOut;
import com.mikhail.web.dto.user.UserRegInfoDtoIn;
import com.mikhail.web.dto.user.UserUpdateInfo;

import java.util.List;

public interface UserService {

    UserFullInfoDtoOut findUserById(final Long id);

    List<UserLiteDtoOut> getAll();

    void registerUser(final UserRegInfoDtoIn regInfoDtoIn);

    void deleteUserById(final Long id);

    void updateUser(final Long id, final UserUpdateInfo updateInfo);

}
