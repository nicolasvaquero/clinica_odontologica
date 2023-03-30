package com.dh.clinica_odontologica.service;

import com.dh.clinica_odontologica.entity.Paciente;
import com.dh.clinica_odontologica.repository.DomicilioRepository;
import com.dh.clinica_odontologica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {


    private PacienteRepository pacienteRepository;

    private DomicilioRepository domicilioRepository;

    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository, DomicilioRepository domicilioRepository) {
        this.pacienteRepository = pacienteRepository;
        this.domicilioRepository = domicilioRepository;
    }

    @Override
    public Paciente agregar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente buscarPorId(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }

    @Override
    public void borrar(Long id) {
        pacienteRepository.delete(buscarPorId(id));

    }

    @Override
    public void actualizar(Paciente paciente) {
        pacienteRepository.save(paciente);
    }
}
