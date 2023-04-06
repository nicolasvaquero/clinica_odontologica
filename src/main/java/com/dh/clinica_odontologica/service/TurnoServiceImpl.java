package com.dh.clinica_odontologica.service;

import com.dh.clinica_odontologica.entity.Turno;
import com.dh.clinica_odontologica.entity.DTO.TurnoDTO;
import com.dh.clinica_odontologica.repository.OdontologoRepository;
import com.dh.clinica_odontologica.repository.PacienteRepository;
import com.dh.clinica_odontologica.repository.TurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TurnoServiceImpl implements TurnoService{

    private TurnoRepository turnoRepository;

    @Autowired
    public TurnoServiceImpl(TurnoRepository turnoRepository, PacienteRepository pacienteRepository, OdontologoRepository odontologoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Autowired
    ObjectMapper mapper;

    private void guardar(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);

        turnoRepository.save(turno);
    }


    @Override
    public void agregar(TurnoDTO turnoDTO) {
        guardar(turnoDTO);
    }

    @Override
    public TurnoDTO buscarPorId(Long id) {
        Turno turno = this.turnoRepository.findById(id).orElse(null);
        TurnoDTO turnoDTO= null;
        if(turno!=null){
            turnoDTO = mapper.convertValue(turno,TurnoDTO.class);
        }
        return turnoDTO;
    }

    @Override
    public Set<TurnoDTO> buscarTodos() {
        List<Turno> turnos= this.turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();
        for(Turno turno:turnos){
            turnosDTO.add(mapper.convertValue(turno,TurnoDTO.class));
        }
        return turnosDTO;
    }

    @Override
    public void borrar(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public void actualizar(TurnoDTO turnoDTO) {
        guardar(turnoDTO);
    }
}
