package org.example.dao.repositories.jdbc;


import jakarta.inject.Inject;
import org.example.dao.common.SQLQueries;
import org.example.dao.mappers.MedicoRowMapper;
import org.example.dao.model.Medico;
import org.example.dao.repositories.MedicoRepository;
import org.example.dao.utils.DBConnection;
import org.example.domain.error.DatabaseError;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCMedicoRepository implements MedicoRepository {

    private final DBConnection dbConnection;
    private final MedicoRowMapper mapper;

    @Inject
    public JDBCMedicoRepository(
            DBConnection dbConnection,
            MedicoRowMapper mapper) {
        this.dbConnection = dbConnection;
        this.mapper = mapper;
    }

    @Override
    public List<Medico> findAll() {
        List<Medico> medicos = new ArrayList<>();

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pstmt =
                     conn.prepareStatement(SQLQueries.FIND_ALL_MEDICOS);
             ResultSet rs = pstmt.executeQuery()) {

            int rowNum = 0;

            while (rs.next()) {
                medicos.add(mapper.mapRow(rs, rowNum++));
            }

            return medicos;

        } catch (SQLException e) {
            throw new DatabaseError(e.getMessage());
        }
    }
}
