package com.alx.infoms.dto;

import com.alx.infoms.utils.PasswordMatches;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;


@PasswordMatches
@Data
public class SignUpDTO {
    @Email
    private String emailAddress;
    @Min(value = 2)
    private String password;
    @Min(value = 2)
    private String confirmPassword;

}
