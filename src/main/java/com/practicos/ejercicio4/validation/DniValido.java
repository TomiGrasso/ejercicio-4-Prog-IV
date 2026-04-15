package com.practicos.ejercicio4.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = DniValidator.class)
public @interface DniValido {

    String message() default "El DNI debe contener entre 7 y 8 dígitos numéricos sin puntos ni espacios";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
