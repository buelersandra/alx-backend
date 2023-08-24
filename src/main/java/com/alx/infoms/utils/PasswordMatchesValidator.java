package com.alx.infoms.utils;

import com.alx.infoms.dto.SignUpDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        SignUpDTO user = (SignUpDTO) obj;
        return user.getPassword().equals(user.getConfirmPassword());
    }
}
