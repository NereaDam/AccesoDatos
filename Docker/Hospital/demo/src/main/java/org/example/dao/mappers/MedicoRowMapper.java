package org.example.dao.mappers;

import org.example.dao.model.Medico;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicoRowMapper {

    public Medico mapRow(ResultSet rs, int rowNum)
            throws SQLException {

        return Medico.builder()
                .medico_id(rs.getLong("medico_id"))
                .nombre(rs.getString("nombre"))
                .especialidad(rs.getString("especialidad"))
                .telefono(rs.getString("telefono"))
                .build();
    }
}