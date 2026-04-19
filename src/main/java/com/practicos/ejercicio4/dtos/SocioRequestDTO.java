package com.practicos.ejercicio4.dtos;

import com.practicos.ejercicio4.validation.DniValido;
import com.practicos.ejercicio4.validation.OnCreate;
import com.practicos.ejercicio4.validation.OnUpdate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

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

    @NotNull(groups = {OnCreate.class}, message = "Fecha de nacimiento obligatoria.")
    @Past(groups = {OnCreate.class, OnUpdate.class}, message = "La fecha no puede ser posterior a hoy.")
    private LocalDate fechaNacimiento;

    @NotNull(groups = {OnCreate.class, OnUpdate.class}, message = "Dirección obligatoria.")
    @Valid
    private DireccionDTO direccion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public DireccionDTO getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDTO direccion) {
        this.direccion = direccion;
    }
}
