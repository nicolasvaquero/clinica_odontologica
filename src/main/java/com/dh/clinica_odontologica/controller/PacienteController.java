package com.dh.clinica_odontologica.controller;


import com.dh.clinica_odontologica.entity.PacienteDTO;
import com.dh.clinica_odontologica.service.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")

public class PacienteController {


    PacienteServiceImpl pacienteService;

    @Autowired
    public PacienteController(PacienteServiceImpl pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/")
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.agregar(pacienteDTO);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO buscarPaciente (@PathVariable Long id){
        return pacienteService.buscarPorId(id);
    }

    @GetMapping("/")
    public Collection<PacienteDTO> listarPacientes(){
        return pacienteService.buscarTodos();
    }

    @PutMapping("/")
    public ResponseEntity<?> actualizarPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.actualizar(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable("id") long id){
        pacienteService.borrar(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
