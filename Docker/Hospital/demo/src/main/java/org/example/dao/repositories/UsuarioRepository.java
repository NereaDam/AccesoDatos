package org.example.dao.repositories;

import org.example.dao.modelo.Usuario;

public interface UsuarioRepository {
    Usuario get(String username);
}
