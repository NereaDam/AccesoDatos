package org.example.dao.repositories;

import org.example.dao.model.HistoriaClinica;

import java.util.List;

public interface HistoriaClinicaRepository {

    List<HistoriaClinica> findByPacienteId(Long pacienteId);

    Long add(HistoriaClinica historia);

    void update(HistoriaClinica historia);

    void delete(Long id);

}
