package com.dh.clinica_odontologica.service;



import com.dh.clinica_odontologica.entity.DTO.OdontologoDTO;

import java.util.Set;


public interface OdontologoService {
    void agregar (OdontologoDTO odontologoDTO);
    OdontologoDTO buscarPorId (Long id);
    Set<OdontologoDTO> buscarTodos();
    void borrar (Long id);
    void actualizar (OdontologoDTO odontologoDTO);
}
