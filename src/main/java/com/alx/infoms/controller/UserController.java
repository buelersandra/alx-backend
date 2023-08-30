package com.alx.infoms.controller;

import com.alx.infoms.common.ApiPaths;
import com.alx.infoms.common.UserNotFoundException;
import com.alx.infoms.dto.*;
import com.alx.infoms.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Tag(name = "Mini Information Management System")
@RestController
@RequestMapping(ApiPaths.VERSION)
@CrossOrigin("*")
@Validated
public class UserController {

    @Inject
    UserService userService;

    @Operation(summary = "Register a user")
    @PostMapping(value =  "/register")
    public ResponseEntity<BaseResponseDTO<SignUpDTO>> register(@RequestBody @Valid SignUpDTO signUpDTO) {
        return userService.register(signUpDTO);
    }

    @Operation(summary = "Login a user")
    @PostMapping(value =  "/login")
    public ResponseEntity<BaseResponseDTO<JWTTokenDTO>> login(@RequestBody @Valid LoginDTO loginDTO) throws UserNotFoundException {
        return userService.login(loginDTO);
    }





}
