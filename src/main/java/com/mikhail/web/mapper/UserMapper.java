package com.mikhail.web.mapper;

import com.mikhail.crudBase.DtoMapper;
import com.mikhail.user.User;
import com.mikhail.web.dto.user.*;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper extends DtoMapper<UserDtoIn, UserLiteDtoOut, User> {

    @Mapping(target = "fullName", expression = "java(user.getName() + \" \" + user.getSurname())")
    UserLiteDtoOut toOut(User user);

    UserFullInfoDtoOut toOutFull(User user);

    User fromIn(UserRegInfoDtoIn regInfoDtoIn);

    void merge(UserRegInfoDtoIn regInfoDtoIn, @MappingTarget User user);
    void merge(UserUpdateInfo updateInfo, @MappingTarget User user);

}
