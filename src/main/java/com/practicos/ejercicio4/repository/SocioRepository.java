package com.practicos.ejercicio4.repository;

import com.practicos.ejercicio4.models.Socio;

import java.util.ArrayList;
import java.util.List;

public class SocioRepository {

    static List<Socio> socios = new ArrayList<>();

    public static void guardarSocio(Socio socio){
        socios.add(socio);
    }

    public static Socio buscarPorId(Long id){

        for (Socio socio: socios){
            if (socio.getId().equals(id)){
                return socio;
            }
        }

        return null;
    }

    public static boolean existsByDni(String dni){

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
