package org.example.dao.repositories.jdbc;

import jakarta.inject.Inject;
import org.example.dao.common.SQLQueries;
import org.example.dao.model.Usuario;
import org.example.dao.repositories.UsuarioRepository;
import org.example.dao.utils.DBConnection;
import org.example.domain.error.AppError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class JDBCUsuarioRepository implements UsuarioRepository {
    private static final Logger log = LoggerFactory.getLogger(JDBCUsuarioRepository.class);

    private final DBConnection dbConnection;

    @Inject
    public JDBCUsuarioRepository(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {


        Usuario usuario = Usuario.builder().username(username).build();
        try (Connection connection= dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.FIND_USUARIO_BY_USERNAME)) {

            log.info(SQLQueries.FIND_USUARIO_BY_USERNAME );
            preparedStatement.setString(1, username);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    usuario.setPassword(rs.getString("password"));
                    log.info( "usuario encontrado: {} ", username);
                    return Optional.of(usuario);
                }
                log.info("usuario no encontrado: {}", username);
                return Optional.empty();
            }

        } catch (SQLException e) {
            log.error("Error en el login");
            throw new AppError(e.getMessage());
        }
    }

}

