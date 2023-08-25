package com.alx.infoms.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class JWTTokenDTO {
    private String accessToken;
    private String message;
}
