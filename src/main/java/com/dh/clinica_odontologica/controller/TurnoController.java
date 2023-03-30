package com.dh.clinica_odontologica.controller;


import com.dh.clinica_odontologica.entity.Turno;
import com.dh.clinica_odontologica.service.OdontologoServiceImpl;
import com.dh.clinica_odontologica.service.PacienteServiceImpl;
import com.dh.clinica_odontologica.service.TurnoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turno")
public class TurnoController {

    private final TurnoServiceImpl turnoService;
    private final PacienteServiceImpl pacienteService;
    private final OdontologoServiceImpl odontologoService;

    @Autowired
    public TurnoController(PacienteServiceImpl pacienteService, TurnoServiceImpl turnoService, OdontologoServiceImpl odontologoService) {
        this.pacienteService = pacienteService;
        this.turnoService = turnoService;
        this.odontologoService = odontologoService;
    }

    @PostMapping("/")
    public Turno agregar (@RequestBody Turno turno){
        return turnoService.agregar(turno);
    }
    @GetMapping("/{id}")
    public Turno buscarPorId (@PathVariable("id") Long id){
        return turnoService.buscarPorId(id);
    }

    @GetMapping("/")
    public List<Turno> buscarTodos(){
        return turnoService.buscarTodos();
    }

    @PutMapping("/")
    public void actualizar(@RequestBody Turno turno){
        turnoService.actualizar(turno);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id){
        turnoService.borrar(id);
    }
}
