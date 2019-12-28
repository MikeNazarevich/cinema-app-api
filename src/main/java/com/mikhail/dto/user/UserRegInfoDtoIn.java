package com.mikhail.dto.user;

import com.mikhail.validator.ValidPassword;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserRegInfoDtoIn {

    @NotBlank
    @Size(max = 30)
    private String name;

    @NotBlank
    @Size(max = 50)
    private String surname;

    @NotBlank
    @ValidPassword
    private String password;
    private String matchingPassword;

    @Email
    @NotBlank
    @Size(max = 120)
    private String email;
}
