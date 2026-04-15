package com.practicos.ejercicio4.dtos;

import com.practicos.ejercicio4.validation.DniValido;
import com.practicos.ejercicio4.validation.OnCreate;
import com.practicos.ejercicio4.validation.OnUpdate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class SocioRequestDTO {

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "Nombre obligatorio.")
    private String nombre;

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "Apellido obligatorio.")
    private String apellido;

    @NotBlank(groups = {OnCreate.class}, message = "DNI obligatorio.")
    @DniValido(groups = OnCreate.class)
    private String dni;

    @NotBlank(groups = {OnCreate.class}, message = "Email obligatorio.")
    @Email(groups = {OnCreate.class, OnUpdate.class}, message = "Formato email NO válido.")
    private String email;

    @NotBlank(groups = {OnCreate.class}, message = "Contraseña obligatoria.")
    @Size(groups = {OnCreate.class}, min = 8, message = "Contraseña muy corta, debe tener al menos 8 caracteres.")
    private String password;

    @NotBlank(groups = {OnCreate.class}, message = "Fecha de nacimiento obligatoria.")
    @Past(groups = {OnCreate.class, OnUpdate.class}, message = "La fecha no puede ser posterior a hoy.")
    private LocalDate fechaNacimiento;

    @Valid
    @NotBlank(groups = {OnCreate.class}, message = "Dirección obligatoria.")
    private DireccionDTO direccion;
}
