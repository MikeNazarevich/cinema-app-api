package com.mikhail.mapper;

import com.mikhail.dto.user.UserDtoIn;
import com.mikhail.dto.user.UserFullInfoDtoOut;
import com.mikhail.dto.user.UserLiteDtoOut;
import com.mikhail.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper extends DtoMapper<UserDtoIn, UserLiteDtoOut, User> {

    UserLiteDtoOut toOut(User user);

    UserFullInfoDtoOut toOutFull(Optional<User> user);

}
