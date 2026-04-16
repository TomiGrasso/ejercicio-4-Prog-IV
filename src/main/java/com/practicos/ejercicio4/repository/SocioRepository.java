package com.practicos.ejercicio4.repository;

import com.practicos.ejercicio4.models.Socio;

import java.util.ArrayList;
import java.util.List;

public class SocioRepository {

    List<Socio> socios = new ArrayList<>();

    public void guardarSocio(Socio socio){
        socios.add(socio);
    }

    public boolean existsByDni(String dni){
        if (dni == null){
            return false;
        }

        for (Socio socio : socios){
            if (dni.equals(socio.getDni())){
                return true;
            }
        }

        return false;
    }
}
