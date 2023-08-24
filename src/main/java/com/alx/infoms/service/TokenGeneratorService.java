package com.alx.infoms.service;

import com.alx.infoms.dto.JWTTokenDTO;
import com.alx.infoms.entity.User;

import java.util.Map;

public interface TokenGeneratorService {
    JWTTokenDTO generateToken(User user);
}