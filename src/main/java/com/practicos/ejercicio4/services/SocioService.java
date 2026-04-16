package com.practicos.ejercicio4.services;

import com.practicos.ejercicio4.dtos.DireccionDTO;
import com.practicos.ejercicio4.dtos.SocioRequestDTO;
import com.practicos.ejercicio4.dtos.SocioResponseDTO;
import com.practicos.ejercicio4.exception.DniDuplicadoException;
import com.practicos.ejercicio4.models.Direccion;
import com.practicos.ejercicio4.models.Socio;
import com.practicos.ejercicio4.repository.SocioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SocioService {

    Long contadorId = 1L;

    public SocioResponseDTO crearSocio(SocioRequestDTO dto){

        Socio socio = new Socio();
        crearSocioDesdeDTO(dto);
        socio.setId(contadorId);
        socio.setFechaRegistro(LocalDateTime.now());

        if (SocioRepository.existsByDni(dto.getDni())) {
            throw new DniDuplicadoException();
        }

        SocioRepository.guardarSocio(socio);
        contadorId++;

        //------------------------------------//

        return null;
    }

    private SocioResponseDTO crearResponseDesdeModelo(Socio socio){

        SocioResponseDTO response = new SocioResponseDTO();
        response.setNombre(socio.getNombre());
        response.setApellido(socio.getApellido());
        response.setEmail(socio.getEmail());
        response.setDireccion(mapearModeloAdto(socio.getDireccion()));

        return response;
    }

    private Socio crearSocioDesdeDTO (SocioRequestDTO dto){

        Socio socio = new Socio();
        socio.setNombre(dto.getNombre());
        socio.setApellido(dto.getApellido());
        socio.setDni(dto.getDni());
        socio.setEmail(dto.getEmail());
        socio.setPassword(dto.getPassword());
        socio.setFechaNacimiento(dto.getFechaNacimiento());
        socio.setDireccion(crearDireccionDesdeDTO(dto.getDireccion()));

        return socio;
    }

    private Direccion crearDireccionDesdeDTO(DireccionDTO dto){

        Direccion direccion = new Direccion();
        direccion.setCalle(dto.getCalle());
        direccion.setCiudad(dto.getCiudad());
        direccion.setProvincia(dto.getProvincia());
        direccion.setCodigoPostal(dto.getCodigoPostal());

        return direccion;
    }

    private DireccionDTO mapearModeloAdto(Direccion direccion){

        DireccionDTO dto = new DireccionDTO();
        dto.setCalle(direccion.getCalle());
        dto.setCiudad(direccion.getCiudad());
        dto.setProvincia(direccion.getProvincia());
        dto.setCodigoPostal(direccion.getCodigoPostal());

        return dto;
    }
}
