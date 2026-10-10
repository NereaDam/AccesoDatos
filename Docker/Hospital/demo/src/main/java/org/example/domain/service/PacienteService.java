package org.example.domain.service;

import jakarta.inject.Inject;
import org.example.dao.repositories.PacienteRepository;
import org.example.domain.dto.PacienteDTO;
import org.example.domain.dto.PacienteDTOAlta;
import org.example.domain.mappers.PacienteDTOMapper;

import java.util.List;

public class PacienteService {
    private final PacienteRepository pacienteRepository;
    private final PacienteDTOMapper pacienteDTOMapper;

    @Inject
    public PacienteService (PacienteRepository pacienteRepository, PacienteDTOMapper pacienteDTOMapper) {
        this.pacienteRepository =  pacienteRepository;
        this.pacienteDTOMapper = pacienteDTOMapper;
    }

    public List<PacienteDTO> getAll() {
        return pacienteDTOMapper.toDTOList(pacienteRepository.findAll());
    }

    public Long add(PacienteDTOAlta pacienteDTO) {
        return pacienteRepository.add(pacienteDTOMapper.toEntity(pacienteDTO));
    }
}

