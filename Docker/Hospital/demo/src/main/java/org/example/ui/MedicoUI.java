package org.example.ui;

import jakarta.inject.Inject;
import org.example.domain.service.MedicoService;

public class MedicoUI {

    private final MedicoService service;

    @Inject
    public MedicoUI(MedicoService service) {
        this.service = service;
    }

    public void getAll() {
        System.out.println("Listado de médicos:");
        service.getAll().forEach(System.out::println);
    }
}
