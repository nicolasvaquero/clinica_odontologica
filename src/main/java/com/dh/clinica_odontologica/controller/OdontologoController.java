package com.dh.clinica_odontologica.controller;

import com.dh.clinica_odontologica.entity.Odontologo;
import com.dh.clinica_odontologica.service.OdontologoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {

    private final OdontologoServiceImpl OdontologoService;

    @Autowired
    public OdontologoController(OdontologoServiceImpl odontologoService) {
        OdontologoService = odontologoService;
    }

    @PostMapping("/")
    public Odontologo agregar (@RequestBody Odontologo Odontologo){
        return OdontologoService.agregar(Odontologo);
    }
    @GetMapping("/{id}")
    public Odontologo buscarPorId (@PathVariable("id") Long id){
        return OdontologoService.buscarPorId(id);
    }

    @GetMapping("/")
    public List<Odontologo> buscarTodos(){
        return OdontologoService.buscarTodos();
    }

    @PutMapping("/")
    public void actualizar(@RequestBody Odontologo Odontologo){
        OdontologoService.actualizar(Odontologo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id){
        OdontologoService.borrar(id);
    }
}

