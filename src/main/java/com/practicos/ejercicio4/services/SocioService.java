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
import java.util.ArrayList;
import java.util.List;

@Service
public class SocioService {

    private SocioRepository socioRepository = new SocioRepository();
    Long contadorId = 1L;

    public SocioResponseDTO crearSocio(SocioRequestDTO dto){

        if (socioRepository.existsByDni(dto.getDni())) {
            throw new DniDuplicadoException();
        }

        Socio socio = crearSocioDesdeDTO(dto);
        socio.setId(contadorId);
        socio.setFechaRegistro(LocalDateTime.now());

        socioRepository.guardarSocio(socio);
        contadorId++;

        SocioResponseDTO response = crearResponseDesdeModelo(socio);

        return response;
    }

    public SocioResponseDTO reemplazarSocio(Long id, SocioRequestDTO dto){

        Socio socio = socioRepository.buscarPorId(id);
        mapearParaReemplazar(dto, socio);
        socioRepository.guardarSocio(socio);

        return crearResponseDesdeModelo(socio);
    }

    public List<SocioResponseDTO> obtenerSocios() {

        List<Socio> socios = socioRepository.obtenerTodosLosSocios();
        List<SocioResponseDTO> response = new ArrayList<>();

        for (Socio socio : socios) {
            response.add(crearResponseDesdeModelo(socio));
        }

        return response;
    }

    public SocioResponseDTO obtenerSocioPorId(Long id){

        Socio socio = socioRepository.buscarPorId(id);
        SocioResponseDTO response = crearResponseDesdeModelo(socio);

        return response;
    }

    //Mapeos

    private void mapearParaReemplazar(SocioRequestDTO dto, Socio socio){

        socio.setNombre(dto.getNombre());
        socio.setApellido(dto.getApellido());
        socio.setEmail(dto.getEmail());
        socio.setFechaNacimiento(dto.getFechaNacimiento());
        socio.setDireccion(crearDireccionDesdeDTO(dto.getDireccion()));
    }

    private SocioResponseDTO crearResponseDesdeModelo(Socio socio){

        SocioResponseDTO response = new SocioResponseDTO();
        response.setId(socio.getId());
        response.setNombre(socio.getNombre());
        response.setApellido(socio.getApellido());
        response.setEmail(socio.getEmail());
        response.setFechaRegistro(socio.getFechaRegistro());
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
