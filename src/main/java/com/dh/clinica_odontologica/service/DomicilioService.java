package com.dh.clinica_odontologica.service;

import com.dh.clinica_odontologica.entity.DomicilioDTO;


import java.util.Set;


public interface DomicilioService {
    void agregar (DomicilioDTO domicilio);
    DomicilioDTO buscarPorId (Long id);
    Set<DomicilioDTO> buscarTodos();
    void borrar (Long id);
    void actualizar (DomicilioDTO domicilioDTO);

}
