package org.example.dao.repositories;

import org.example.dao.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> findByUsername(String username);
}
