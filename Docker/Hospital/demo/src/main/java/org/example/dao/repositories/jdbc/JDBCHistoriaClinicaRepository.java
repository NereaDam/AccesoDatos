package org.example.dao.repositories.jdbc;


import jakarta.inject.Inject;
import org.example.dao.common.SQLQueries;
import org.example.dao.mappers.HistoriaClinicaRowMapper;
import org.example.dao.model.HistoriaClinica;
import org.example.dao.repositories.HistoriaClinicaRepository;
import org.example.dao.utils.DBConnection;
import org.example.domain.error.DatabaseError;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCHistoriaClinicaRepository
        implements HistoriaClinicaRepository {

    private final DBConnection dbConnection;
    private final HistoriaClinicaRowMapper mapper;

    @Inject
    public JDBCHistoriaClinicaRepository(
            DBConnection dbConnection,
            HistoriaClinicaRowMapper mapper) {
        this.dbConnection = dbConnection;
        this.mapper = mapper;
    }

    @Override
    public List<HistoriaClinica> findByPacienteId(Long pacienteId) {
        List<HistoriaClinica> historias = new ArrayList<>();

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pstmt =
                     conn.prepareStatement(
                             SQLQueries.FIND_HISTORIAS_BY_PACIENTE)) {

            pstmt.setLong(1, pacienteId);

            try (ResultSet rs = pstmt.executeQuery()) {
                int rowNum = 0;

                while (rs.next()) {
                    historias.add(mapper.mapRow(rs, rowNum++));
                }
            }

            return historias;

        } catch (SQLException e) {
            throw new DatabaseError(e.getMessage());
        }
    }

    @Override
    public Long add(HistoriaClinica historia) {
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     SQLQueries.ADD_HISTORIA,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setLong(1, historia.getPacienteId());
            pstmt.setLong(2, historia.getMedicoId());
            pstmt.setString(3, historia.getDiagnostico());

            if (historia.getFechaAdmision() == null) {
                pstmt.setNull(4, Types.DATE);
            } else {
                pstmt.setDate(
                        4, Date.valueOf(historia.getFechaAdmision())
                );
            }

            pstmt.executeUpdate();

            try (ResultSet keys = pstmt.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getLong(1);
                }
            }

            throw new DatabaseError("No se generó el ID de la historia");

        } catch (SQLException e) {
            throw new DatabaseError(e.getMessage());
        }
    }

    @Override
    public void update(HistoriaClinica historia) {
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pstmt =
                     conn.prepareStatement(SQLQueries.UPDATE_HISTORIA)) {

            pstmt.setLong(1, historia.getPacienteId());
            pstmt.setLong(2, historia.getMedicoId());
            pstmt.setString(3, historia.getDiagnostico());

            if (historia.getFechaAdmision() == null) {
                pstmt.setNull(4, Types.DATE);
            } else {
                pstmt.setDate(
                        4, Date.valueOf(historia.getFechaAdmision())
                );
            }

            pstmt.setLong(5, historia.getHistoria_id());

            int filas = pstmt.executeUpdate();

            if (filas == 0) {
                throw new DatabaseError("No existe esa historia clínica");
            }

        } catch (SQLException e) {
            throw new DatabaseError(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pstmt =
                     conn.prepareStatement(SQLQueries.DELETE_HISTORIA)) {

            pstmt.setLong(1, id);

            int filas = pstmt.executeUpdate();

            if (filas == 0) {
                throw new DatabaseError("No existe esa historia clínica");
            }

        } catch (SQLException e) {
            throw new DatabaseError(e.getMessage());
        }
    }
}