package org.example.domain.service;

import jakarta.inject.Inject;
import org.example.dao.repositories.UsuarioRepository;

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Inject
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository=usuarioRepository;
    }

    public boolean get(){

    }
}
