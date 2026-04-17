package com.practicos.ejercicio4.controllers;


import com.practicos.ejercicio4.dtos.SocioRequestDTO;
import com.practicos.ejercicio4.dtos.SocioResponseDTO;
import com.practicos.ejercicio4.services.SocioService;
import com.practicos.ejercicio4.validation.OnCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/socios")
public class SocioController {

    @Autowired
    private SocioService service;

    @PostMapping
    public ResponseEntity<SocioResponseDTO>
        crear(@Validated(OnCreate.class) @RequestBody SocioRequestDTO dto){
            SocioResponseDTO creado = service.crearSocio(dto);

            URI location = URI.create("/api/socios/" + creado.getId());

            return ResponseEntity
                    .created(location)
                    .body(creado);
    }

}
