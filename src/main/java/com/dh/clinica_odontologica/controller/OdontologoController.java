package com.dh.clinica_odontologica.controller;

import com.dh.clinica_odontologica.entity.OdontologoDTO;
import com.dh.clinica_odontologica.service.OdontologoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontolgos")
public class OdontologoController {
    private final OdontologoServiceImpl odontologoService;
    @Autowired

    public OdontologoController(OdontologoServiceImpl odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping("/")
    public ResponseEntity<?> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.agregar(odontologoDTO);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO buscarOdontologo (@PathVariable Long id){
        return odontologoService.buscarPorId(id);
    }

    @GetMapping("/")
    public Collection<OdontologoDTO> listarPacientes(){
        return odontologoService.buscarTodos();
    }

    @PutMapping("/")
    public ResponseEntity<?> actualizarOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.actualizar(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable("id") long id){
        odontologoService.borrar(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
