package org.example.dao.model;

import lombok.*;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HistoriaClinica {

    private Long historia_id;
    private Long pacienteId;
    private Long medicoId;
    private String diagnostico;
    private LocalDate fechaAdmision;
}
