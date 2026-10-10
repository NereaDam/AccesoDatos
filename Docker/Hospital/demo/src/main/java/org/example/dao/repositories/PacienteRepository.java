package org.example.dao.repositories;

import org.example.dao.model.Paciente;

import java.util.List;

public interface PacienteRepository {
    List<Paciente> findAll();
    Long add (Paciente paciente);
}
