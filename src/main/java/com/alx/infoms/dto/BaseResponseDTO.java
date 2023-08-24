package com.alx.infoms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class BaseResponseDTO<T> {
    private String message;
    private T data;
}
