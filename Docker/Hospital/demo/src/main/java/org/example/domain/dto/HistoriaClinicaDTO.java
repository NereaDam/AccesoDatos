package org.example.domain.dto;

import lombok.*;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoriaClinicaDTO {
    private Long id;
    private Long pacienteId;
    private Long medicoId;
    private String diagnostico;
    private LocalDate fechaAdmision;
}
