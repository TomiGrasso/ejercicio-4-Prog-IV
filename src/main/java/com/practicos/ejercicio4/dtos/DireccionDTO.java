package com.practicos.ejercicio4.dtos;

import com.practicos.ejercicio4.validation.OnCreate;
import com.practicos.ejercicio4.validation.OnUpdate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DireccionDTO {

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "Calle Obligatoria.")
    @Size(groups = {OnCreate.class, OnUpdate.class}, min = 5, max = 150, message = "Mínimo 5 caractéres, máximo 100.")
    private String calle;

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "Ciudad Obligatoria.")
    @Size(groups = {OnCreate.class, OnUpdate.class}, min = 3, max = 80, message = "Mínimo 3 caractéres, máximo 80.")
    private String ciudad;

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "Provincia Obligatoria.")
    private String provincia;

    @Pattern(groups = {OnCreate.class, OnUpdate.class}, regexp = "\\d{4}", message = "Formato requerido 0000.")
    private String codigoPostal;

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
