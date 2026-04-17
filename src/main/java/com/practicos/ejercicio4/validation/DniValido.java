package com.practicos.ejercicio4.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = DniValidator.class)
@Target({ FIELD })
@Retention(RUNTIME)
public @interface DniValido {

    String message() default "El DNI debe contener entre 7 y 8 dígitos numéricos sin puntos ni espacios";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
