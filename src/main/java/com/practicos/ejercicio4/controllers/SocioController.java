package com.practicos.ejercicio4.controllers;


import com.practicos.ejercicio4.dtos.SocioRequestDTO;
import com.practicos.ejercicio4.dtos.SocioResponseDTO;
import com.practicos.ejercicio4.services.SocioService;
import com.practicos.ejercicio4.validation.OnCreate;
import com.practicos.ejercicio4.validation.OnUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/socios")
public class SocioController {

    @Autowired
    private SocioService service;

    @GetMapping
    public ResponseEntity<List<SocioResponseDTO>> mostrar(){
        return ResponseEntity.ok(service.obtenerSocios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SocioResponseDTO>
        mostrarPorId(@PathVariable Long id){
            return ResponseEntity.ok(service.obtenerSocioPorId(id));
    }

    @PostMapping
    public ResponseEntity<SocioResponseDTO>
        crear(@Validated(OnCreate.class) @RequestBody SocioRequestDTO dto){
            SocioResponseDTO creado = service.crearSocio(dto);

            URI location = URI.create("/api/socios/" + creado.getId());

            return ResponseEntity
                    .created(location)
                    .body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SocioResponseDTO>
        reemplazar(@PathVariable Long id,
                   @Validated(OnUpdate.class) @RequestBody SocioRequestDTO dto){

        return ResponseEntity.ok(service.reemplazarSocio(id, dto));
    }


}
