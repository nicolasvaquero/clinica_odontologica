package com.dh.clinica_odontologica.service;

import com.dh.clinica_odontologica.entity.Turno;
import com.dh.clinica_odontologica.repository.OdontologoRepository;
import com.dh.clinica_odontologica.repository.PacienteRepository;
import com.dh.clinica_odontologica.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoServiceImpl implements TurnoService{

    private TurnoRepository turnoRepository;

    @Autowired
    public TurnoServiceImpl(TurnoRepository turnoRepository, PacienteRepository pacienteRepository, OdontologoRepository odontologoRepository) {
        this.turnoRepository = turnoRepository;
    }




    @Override
    public Turno agregar(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public Turno buscarPorId(Long id) {
        return turnoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Turno> buscarTodos() {
        return turnoRepository.findAll();
    }

    @Override
    public void borrar(Long id) {
        turnoRepository.delete(buscarPorId(id));
    }

    @Override
    public void actualizar(Turno turno) {
        turnoRepository.save(turno);
    }
}
