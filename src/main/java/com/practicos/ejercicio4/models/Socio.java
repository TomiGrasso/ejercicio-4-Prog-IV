package com.practicos.ejercicio4.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Socio {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String password;
    private LocalDateTime fechaRegistro;
    private LocalDate fechaNacimiento;
    private LocalDate fechaVencimientoMembresia;
    private Direccion direccion;

    public Socio(Long id, String nombre, String apellido, String dni, String email, String password, LocalDateTime fechaRegistro, LocalDate fechaNacimiento, LocalDate fechaVencimientoMembresia,Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.password = password;
        this.fechaRegistro = fechaRegistro;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaVencimientoMembresia = fechaVencimientoMembresia;
        this.direccion = direccion;
    }

    public Socio(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaVencimientoMembresia() {
        return fechaVencimientoMembresia;
    }

    public void setFechaVencimientoMembresia(LocalDate fechaVencimientoMembresia) {
        this.fechaVencimientoMembresia = fechaVencimientoMembresia;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
