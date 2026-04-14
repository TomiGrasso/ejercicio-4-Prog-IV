package com.practicos.ejercicio4.models;

import java.time.LocalDate;

public class Socio {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String mail;
    private String password;
    private LocalDate fechaNacimiento;
    private Direccion direccion;

    public Socio(Long id, String nombre, String apellido, String dni, String mail, String password, LocalDate fechaNacimiento, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.mail = mail;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String contrasenia) {
        this.password = contrasenia;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
