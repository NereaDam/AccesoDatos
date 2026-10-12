package org.example.dao.repositories;

import org.example.dao.model.Medico;

import java.util.List;

public interface MedicoRepository {


    List<Medico> findAll();

}
