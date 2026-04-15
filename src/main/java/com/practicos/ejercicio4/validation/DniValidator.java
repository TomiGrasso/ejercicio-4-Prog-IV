package com.practicos.ejercicio4.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DniValidator implements ConstraintValidator<DniValido,String> {

    public boolean isValid(String dni, ConstraintValidatorContext constraintValidatorContext) {
        if (dni == null) return false;
        return dni.matches("\\d{7,8}");
    }
}
