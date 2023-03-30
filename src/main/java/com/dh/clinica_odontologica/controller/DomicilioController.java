package com.dh.clinica_odontologica.controller;

import com.dh.clinica_odontologica.entity.Domicilio;
import com.dh.clinica_odontologica.service.DomicilioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domicilio")

public class DomicilioController {


    private final DomicilioServiceImpl domicilioService;

    @Autowired
    public DomicilioController(DomicilioServiceImpl domicilioService) {
        this.domicilioService = domicilioService;
    }

    @PostMapping("/")
    public Domicilio agregar (@RequestBody Domicilio domicilio){
        return domicilioService.agregar(domicilio);
    }
    @GetMapping("/{id}")
    public Domicilio buscarPorId (@PathVariable("id") Long id){
        return domicilioService.buscarPorId(id);
    }

    @GetMapping("/")
    public List<Domicilio> buscarTodos(){
        return domicilioService.buscarTodos();
    }

    @PutMapping("/")
    public void actualizar(@RequestBody Domicilio domicilio){
        domicilioService.actualizar(domicilio);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id){
        domicilioService.borrar(id);
    }

}
