package com.dh.clinica_odontologica.service;


import com.dh.clinica_odontologica.entity.Paciente;

import java.util.List;

public interface PacienteService {
    Paciente agregar (Paciente paciente);
    Paciente buscarPorId (Long id);
    List<Paciente> buscarTodos();
    void borrar (Long id);
    void actualizar (Paciente domicilio);
}
