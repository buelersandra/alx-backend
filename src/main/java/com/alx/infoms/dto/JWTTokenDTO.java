package com.alx.infoms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class JWTTokenDTO {
    private String accessToken;
    private String message;
}
