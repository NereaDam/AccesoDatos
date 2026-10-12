package org.example.domain.service;

import jakarta.inject.Inject;
import org.example.dao.repositories.HistoriaClinicaRepository;
import org.example.domain.dto.HistoriaClinicaDTO;
import org.example.domain.mappers.HistoriaClinicaDTOMapper;

import java.util.List;

public class HistoriaClinicaService {

    private final HistoriaClinicaRepository repository;
    private final HistoriaClinicaDTOMapper mapper;

    @Inject
    public HistoriaClinicaService(
            HistoriaClinicaRepository repository,
            HistoriaClinicaDTOMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<HistoriaClinicaDTO> findByPacienteId(Long pacienteId) {
        return mapper.toDTOList(
                repository.findByPacienteId(pacienteId)
        );
    }

    public Long add(HistoriaClinicaDTO dto) {
        return repository.add(mapper.toEntity(dto));
    }

    public void update(HistoriaClinicaDTO dto) {
        repository.update(mapper.toEntity(dto));
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
