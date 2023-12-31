package com.alx.infoms.service;

import com.alx.infoms.common.UserNotFoundException;
import com.alx.infoms.dto.BaseResponseDTO;
import com.alx.infoms.dto.JWTTokenDTO;
import com.alx.infoms.dto.LoginDTO;
import com.alx.infoms.dto.SignUpDTO;
import com.alx.infoms.entity.User;
import com.alx.infoms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenGeneratorService tokenGeneratorService;

    PasswordEncoder passwordEncoder =
            PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    public ResponseEntity<BaseResponseDTO<SignUpDTO>> register(SignUpDTO signUpDTO) {
        if(!signUpDTO.getPassword().equals(signUpDTO.getConfirmPassword())){
            return new ResponseEntity<>(new BaseResponseDTO<>(
                    "Passwords do not match",
                    signUpDTO),
                    HttpStatus.BAD_REQUEST);
        }
        userRepository.save(new User(signUpDTO.getEmailAddress(),
                passwordEncoder.encode(signUpDTO.getPassword())));
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BaseResponseDTO<JWTTokenDTO>> login(LoginDTO loginDTO) throws UserNotFoundException {
        Optional<User> user = userRepository.findByEmailAddress(loginDTO.getEmailAddress());
        if(!user.isPresent()){
            throw new UserNotFoundException("Invalid id or password");
        }if(!passwordEncoder.matches(loginDTO.getPassword(), user.get().getPassword())){
            throw new UserNotFoundException("Invalid id or password");
        }

        return new ResponseEntity<>(new BaseResponseDTO<JWTTokenDTO>(null,
                tokenGeneratorService.generateToken(user.get())),
                null, HttpStatus.OK);

    }
}
