package org.example.domain.mappers;

import org.example.dao.model.Medico;
import org.example.domain.dto.MedicoDTO;

import java.util.List;

public class MedicoDTOMapper {

    public MedicoDTO toDTO(Medico medico) {
        return MedicoDTO.builder()
                .id(medico.getMedico_id())
                .nombre(medico.getNombre())
                .especialidad(medico.getEspecialidad())
                .telefono(medico.getTelefono())
                .build();
    }

    public List<MedicoDTO> toDTOList(List<Medico> medicos) {
        return medicos.stream()
                .map(this::toDTO)
                .toList();
    }
}
