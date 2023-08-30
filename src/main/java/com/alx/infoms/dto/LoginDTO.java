package com.alx.infoms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    @NotNull
    @NotEmpty
    @Email(regexp = "^(.+)@(\\S+)$")
    private String emailAddress;

    @NonNull
    @NotEmpty
    private String password;
}
