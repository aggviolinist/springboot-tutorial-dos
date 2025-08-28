package com.authorizen.userauthh.auth;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import com.authorizen.userauthh.dto.RegisterRequest; // Your DTO

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        if (obj instanceof RegisterRequest) {
            RegisterRequest user = (RegisterRequest) obj;
            // Compare password with confirmPassword
            return user.getPassword() != null && user.getPassword().equals(user.getConfirmPassword());
        }
        return false;
    }
}