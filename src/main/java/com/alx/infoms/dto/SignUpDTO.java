package com.alx.infoms.dto;

import com.alx.infoms.utils.PasswordMatches;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@PasswordMatches
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDTO {
    @Email(regexp = "^(.+)@(\\S+)$")
    private String emailAddress;
    @NonNull
    @NotEmpty
    private String password;
    @NonNull
    @NotEmpty
    private String confirmPassword;

}
