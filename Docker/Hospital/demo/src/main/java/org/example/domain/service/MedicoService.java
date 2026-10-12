package org.example.domain.service;

import jakarta.inject.Inject;
import org.example.dao.repositories.MedicoRepository;
import org.example.domain.dto.MedicoDTO;
import org.example.domain.mappers.MedicoDTOMapper;

import java.util.List;

public class MedicoService {

    private final MedicoRepository medicoRepository;
    private final MedicoDTOMapper mapper;

    @Inject
    public MedicoService(
            MedicoRepository medicoRepository,
            MedicoDTOMapper mapper) {
        this.medicoRepository = medicoRepository;
        this.mapper = mapper;
    }

    public List<MedicoDTO> getAll() {
        return mapper.toDTOList(medicoRepository.findAll());
    }
}
