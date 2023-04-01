package com.dh.clinica_odontologica.service;




import com.dh.clinica_odontologica.entity.PacienteDTO;


import java.util.Set;

public interface PacienteService {
    void agregar (PacienteDTO pacienteDTO);
    PacienteDTO buscarPorId (Long id);
    Set<PacienteDTO> buscarTodos();
    void borrar (Long id);
    void actualizar (PacienteDTO pacienteDTO);

}
