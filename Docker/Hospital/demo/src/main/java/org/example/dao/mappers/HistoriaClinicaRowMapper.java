package org.example.dao.mappers;

import org.example.dao.model.HistoriaClinica;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoriaClinicaRowMapper {

    public HistoriaClinica mapRow(
            ResultSet rs, int rowNum) throws SQLException {

        return HistoriaClinica.builder()
                .historia_id(rs.getLong("historia_id"))
                .pacienteId(rs.getLong("paciente_id"))
                .medicoId(rs.getLong("medico_id"))
                .diagnostico(rs.getString("diagnostico"))
                .fechaAdmision(
                        rs.getDate("fecha_admision") == null
                                ? null
                                : rs.getDate("fecha_admision").toLocalDate()
                )
                .build();
    }
}
