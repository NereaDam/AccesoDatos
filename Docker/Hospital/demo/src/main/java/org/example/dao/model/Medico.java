package org.example.dao.model;


import lombok.*;


@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Medico {

    private Long medico_id;
    private String nombre;
    private String especialidad;
    private String telefono;

}
