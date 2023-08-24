package com.alx.infoms.dto;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.*;

@Data
public class LoginDTO {

    @NotNull
    @NotEmpty
    @Email
    private String emailAddress;

    @Min(value = 2)
    private String password;
}
