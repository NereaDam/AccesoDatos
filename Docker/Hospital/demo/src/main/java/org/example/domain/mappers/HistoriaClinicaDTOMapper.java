package org.example.domain.mappers;

import org.example.dao.model.HistoriaClinica;
import org.example.domain.dto.HistoriaClinicaDTO;

import java.util.List;

public class HistoriaClinicaDTOMapper {

    public HistoriaClinicaDTO toDTO(HistoriaClinica historia) {
        return HistoriaClinicaDTO.builder()
                .id(historia.getHistoria_id())
                .pacienteId(historia.getPacienteId())
                .medicoId(historia.getMedicoId())
                .diagnostico(historia.getDiagnostico())
                .fechaAdmision(historia.getFechaAdmision())
                .build();
    }

    public HistoriaClinica toEntity(HistoriaClinicaDTO dto) {
        return HistoriaClinica.builder()
                .historia_id(dto.getId())
                .pacienteId(dto.getPacienteId())
                .medicoId(dto.getMedicoId())
                .diagnostico(dto.getDiagnostico())
                .fechaAdmision(dto.getFechaAdmision())
                .build();
    }

    public List<HistoriaClinicaDTO> toDTOList(
            List<HistoriaClinica> historias) {
        return historias.stream()
                .map(this::toDTO)
                .toList();
    }
}