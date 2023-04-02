package com.dh.clinica_odontologica.controller;


import com.dh.clinica_odontologica.entity.TurnoDTO;
import com.dh.clinica_odontologica.service.TurnoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    TurnoServiceImpl turnoService;
    @Autowired
    public TurnoController(TurnoServiceImpl turnoService) {
        this.turnoService = turnoService;
    }


    @PostMapping("/")


    public ResponseEntity<?> crearTurno(@RequestBody TurnoDTO turnoDTO){
        turnoService.agregar(turnoDTO);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TurnoDTO buscarTurno (@PathVariable Long id){
        return turnoService.buscarPorId(id);
    }

    @GetMapping("/")
    public Collection<TurnoDTO> listarTurno(){
        return turnoService.buscarTodos();
    }

    @PutMapping("/")
    public ResponseEntity<?> actualizarTurno(@RequestBody TurnoDTO turnoDTO){
        turnoService.actualizar(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable("id") long id){
        turnoService.borrar(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
