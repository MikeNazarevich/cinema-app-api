package com.mikhail.web.mapper;

import com.mikhail.crudBase.DtoMapper;
import com.mikhail.user.User;
import com.mikhail.web.dto.user.UserDtoIn;
import com.mikhail.web.dto.user.UserFullInfoDtoOut;
import com.mikhail.web.dto.user.UserLiteDtoOut;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper extends DtoMapper<UserDtoIn, UserLiteDtoOut, User> {

    @Mapping(target = "fullName", expression = "java(user.getName() + \" \" + user.getSurname())")
    UserLiteDtoOut toOut(User user);

    UserFullInfoDtoOut toOutFull(User user);

}
