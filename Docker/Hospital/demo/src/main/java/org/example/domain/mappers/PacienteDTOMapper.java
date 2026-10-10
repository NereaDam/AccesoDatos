package org.example.domain.mappers;

import org.example.dao.model.Paciente;
import org.example.dao.model.Usuario;
import org.example.domain.dto.PacienteDTO;
import org.example.domain.dto.PacienteDTOAlta;

import java.util.ArrayList;
import java.util.List;

public class PacienteDTOMapper
{
    public PacienteDTO toDTO(Paciente paciente) {
        return PacienteDTO.builder()
                .id(paciente.getId())
                .nombre(paciente.getNombre())
                .fechaNacimiento(paciente.getFechaNacimiento())
                .telefono(paciente.getTelefono())
                .build();
    }

    public Paciente toEntity(PacienteDTO pacienteDTO) {
        return Paciente.builder()
                .id(pacienteDTO.getId())
                .nombre(pacienteDTO.getNombre())
                .fechaNacimiento(pacienteDTO.getFechaNacimiento())
                .telefono(pacienteDTO.getTelefono())
                .build();
    }

    public Paciente toEntity(PacienteDTOAlta pacienteDTO) {
        return Paciente.builder()
                .nombre(pacienteDTO.getNombre())
                .fechaNacimiento(pacienteDTO.getFechaNacimiento())
                .telefono(pacienteDTO.getTelefono())
                .usuario(Usuario.builder()
                        .username(pacienteDTO.getUsername())
                        .password(pacienteDTO.getPassword())
                        .build())
                .build();
    }


    public List<PacienteDTO> toDTOList(List<Paciente> pacientes) {
        List<PacienteDTO> listaDtos = new ArrayList<>();
    /*
    // Manera 1: Usando for
    for (Paciente paciente : pacientes)  {
      listaDtos.add(toDTO(paciente));
    }
    */

        // Manera 2: Usando forEach y lambda
        pacientes.forEach(paciente -> listaDtos.add(toDTO(paciente)));
        return listaDtos;
    }

}