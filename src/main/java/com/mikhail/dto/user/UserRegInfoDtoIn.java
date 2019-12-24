package com.mikhail.dto.user;

import com.mikhail.validator.ValidPassword;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserRegInfoDtoIn {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    @ValidPassword
    private String password;
    private String matchingPassword;

    @Email
    @NotBlank
    private String email;
}
