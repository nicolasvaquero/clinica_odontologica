package com.dh.clinica_odontologica.service;

import com.dh.clinica_odontologica.entity.Paciente;
import com.dh.clinica_odontologica.entity.PacienteDTO;
import com.dh.clinica_odontologica.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PacienteServiceImpl implements PacienteService {


    private final PacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;


    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }


    @Override
    public void agregar(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO,Paciente.class);
        pacienteRepository.save(paciente);
    }

    private void guardar(PacienteDTO pacienteDTO){
        Paciente paciente = mapper.convertValue(pacienteDTO,Paciente.class);
        pacienteRepository.save(paciente);
    }

    @Override
    public PacienteDTO buscarPorId(Long id) {
        Paciente paciente = this.pacienteRepository.findById(id).orElse(null);
        PacienteDTO pacienteDTO= null;
        if(paciente!=null){
            pacienteDTO = mapper.convertValue(paciente,PacienteDTO.class);
        }
        return pacienteDTO;
    }

    @Override
    public Set<PacienteDTO> buscarTodos() {
        List<Paciente> pacientes= this.pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        for(Paciente paciente:pacientes){
            pacientesDTO.add(mapper.convertValue(paciente,PacienteDTO.class));
        }
        return pacientesDTO;
    }

    @Override
    public void borrar(Long id) {
        this.pacienteRepository.deleteById(id);
    }

    @Override
    public void actualizar(PacienteDTO pacienteDTO) {
        guardar(pacienteDTO);
    }
}

