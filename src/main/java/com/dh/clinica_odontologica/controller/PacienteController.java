package com.dh.clinica_odontologica.controller;

import com.dh.clinica_odontologica.entity.Paciente;
import com.dh.clinica_odontologica.service.DomicilioServiceImpl;
import com.dh.clinica_odontologica.service.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteServiceImpl pacienteService;
    private final DomicilioServiceImpl domicilioService;

    @Autowired
    public PacienteController(PacienteServiceImpl pacienteService, DomicilioServiceImpl domicilioService) {
        this.pacienteService = pacienteService;
        this.domicilioService = domicilioService;
    }

    @PostMapping("/")
    public Paciente agregar (@RequestBody Paciente paciente){
        return pacienteService.agregar(paciente);
    }
    @GetMapping("/{id}")
    public Paciente buscarPorId (@PathVariable("id") Long id){
        return pacienteService.buscarPorId(id);
    }

    @GetMapping("/")
    public List<Paciente> buscarTodos(){
        return pacienteService.buscarTodos();
    }

    @PutMapping("/")
    public void actualizar(@RequestBody Paciente paciente){
        pacienteService.actualizar(paciente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id){
        pacienteService.borrar(id);
    }
}
