package com.practicos.ejercicio4.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DireccionDTO {

    @NotBlank(message = "Calle Obligatoria.")
    @Size(min = 5, max = 150, message = "Mínimo 5 caractéres, máximo 100.")
    private String calle;

    @NotBlank(message = "Ciudad Obligatoria.")
    @Size(min = 3, max = 80, message = "Mínimo 3 caractéres, máximo 80.")
    private String ciudad;

    @NotBlank(message = "Provincia Obligatoria.")
    private String provincia;

    @Pattern(regexp = "\\d{4}", message = "Formato requerido 0000.")
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
