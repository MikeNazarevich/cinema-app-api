package com.mikhail.mapper;

import com.mikhail.dto.user.*;
import com.mikhail.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper extends DtoMapper<UserDtoIn, UserLiteDtoOut, User> {

    UserLiteDtoOut toOut(User user);

    UserFullInfoDtoOut toOutFull(User user);

    void merge(UserRegInfoDtoIn regInfoDtoIn, @MappingTarget User user);
    void merge(UserUpdateInfo updateInfo, @MappingTarget User user);

}
