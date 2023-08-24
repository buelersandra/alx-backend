package com.alx.infoms.service;

import com.alx.infoms.common.UserNotFoundException;
import com.alx.infoms.dto.BaseResponseDTO;
import com.alx.infoms.dto.JWTTokenDTO;
import com.alx.infoms.dto.LoginDTO;
import com.alx.infoms.dto.SignUpDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<BaseResponseDTO<SignUpDTO>> register(SignUpDTO signUpDTO);

    public ResponseEntity<BaseResponseDTO<JWTTokenDTO>> login(LoginDTO loginDTO) throws UserNotFoundException;
}
