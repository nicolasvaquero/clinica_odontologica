package com.dh.clinica_odontologica.service;

import com.dh.clinica_odontologica.entity.Turno;

import java.util.List;


public interface TurnoService {
    Turno agregar (Turno turno);
    Turno buscarPorId (Long id);
    List<Turno> buscarTodos();
    void borrar (Long id);
    void actualizar (Turno turno);
}
