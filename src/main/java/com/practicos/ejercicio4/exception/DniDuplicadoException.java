package com.practicos.ejercicio4.exception;

public class DniDuplicadoException extends RuntimeException {

    public DniDuplicadoException() {
        super("El DNI ingresado ya se encuentra registrado en el sistema.");
    }
}
