package com.authorizen.userauthh.auth;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import com.authorizen.userauthh.dto.RegisterRequest;


public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        if (obj instanceof RegisterRequest user) {
            boolean passwordsMatch = user.getPassword() != null && user.getPassword().equals(user.getConfirmPassword());

            if (!passwordsMatch) {
                // Disable the default generic error message.
                context.disableDefaultConstraintViolation();
                // Create a new error message and attach it to the 'confirmPassword' field.
                context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                       .addPropertyNode("confirmPassword")
                       .addConstraintViolation();
            }

            return passwordsMatch;
        }
        return false;
    }
}


// public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

//     @Override
//     public boolean isValid(Object obj, ConstraintValidatorContext context) {
//         if (obj instanceof RegisterRequest user) {
//             boolean passwordsMatch = user.getPassword() != null && user.getPassword().equals(user.getConfirmPassword());

//             if (!passwordsMatch) {
//                 // Disable the default, generic error message
//                 context.disableDefaultConstraintViolation();
//                 // Build a new error message and attach it to the 'confirmPassword' field
//                 context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
//                        .addPropertyNode("confirmPassword")
//                        .addConstraintViolation();
//             }

//             return passwordsMatch;
//         }
//         return false;
//     }
// }