package com.dh.clinica_odontologica.service;

import com.dh.clinica_odontologica.entity.DTO.TurnoDTO;

import java.util.Set;


public interface TurnoService {
    void agregar (TurnoDTO turnoDTO);
    TurnoDTO buscarPorId (Long id);
    Set<TurnoDTO> buscarTodos();
    void borrar (Long id);
    void actualizar (TurnoDTO turnoDTO);
}
