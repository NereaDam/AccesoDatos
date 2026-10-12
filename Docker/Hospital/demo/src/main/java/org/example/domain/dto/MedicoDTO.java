package org.example.domain.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoDTO {
    private Long id;
    private String nombre;
    private String especialidad;
    private String telefono;
}