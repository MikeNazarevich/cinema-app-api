package com.mikhail.dto.user;

import com.mikhail.validator.ValidPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserRegInfoDtoIn {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @ValidPassword
    private String password;
    private String matchingPassword;

    @Email
    @NotBlank
    private String email;
}
