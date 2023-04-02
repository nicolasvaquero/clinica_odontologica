package com.dh.clinica_odontologica.controller;

import com.dh.clinica_odontologica.entity.DomicilioDTO;
import com.dh.clinica_odontologica.service.DomicilioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {
    private final DomicilioServiceImpl domicilioService;

    @Autowired
    public DomicilioController(DomicilioServiceImpl domicilioService) {
        this.domicilioService = domicilioService;
    }



    @PostMapping("/")
    public ResponseEntity<?> crearDomicilio(@RequestBody DomicilioDTO domicilioDTO){
        domicilioService.agregar(domicilioDTO);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DomicilioDTO buscarDomicilio (@PathVariable Long id){
        return domicilioService.buscarPorId(id);
    }

    @GetMapping("/")
    public Collection<DomicilioDTO> listarDomicilios(){
        return domicilioService.buscarTodos();
    }

    @PutMapping("/")
    public ResponseEntity<?> actualizarDomicilio(@RequestBody DomicilioDTO domicilioDTO){
        domicilioService.actualizar(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable("id") long id){
        domicilioService.borrar(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
