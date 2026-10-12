package org.example.ui;

import jakarta.inject.Inject;
import org.example.domain.dto.HistoriaClinicaDTO;
import org.example.domain.service.HistoriaClinicaService;

import java.time.LocalDate;
import java.util.Scanner;


public class HistoriaClinicaUI {

    private final HistoriaClinicaService service;
    private final Scanner scanner;
@Inject
public HistoriaClinicaUI(HistoriaClinicaService service) {
    this.service = service;
    this.scanner = new Scanner(System.in);
}

public void findByPacienteId() {
    System.out.print("ID del paciente: ");
    Long pacienteId = Long.parseLong(scanner.nextLine());

    service.findByPacienteId(pacienteId)
            .forEach(System.out::println);
}

public void add() {
    System.out.print("ID del paciente: ");
    Long pacienteId = Long.parseLong(scanner.nextLine());

    System.out.print("ID del médico: ");
    Long medicoId = Long.parseLong(scanner.nextLine());

    System.out.print("Diagnóstico: ");
    String diagnostico = scanner.nextLine();

    System.out.print("Fecha de admisión (AAAA-MM-DD): ");
    String fechaTexto = scanner.nextLine();

    LocalDate fecha = fechaTexto.isBlank()
            ? null
            : LocalDate.parse(fechaTexto);

    HistoriaClinicaDTO dto = HistoriaClinicaDTO.builder()
            .pacienteId(pacienteId)
            .medicoId(medicoId)
            .diagnostico(diagnostico)
            .fechaAdmision(fecha)
            .build();

    System.out.println(
            "Historia creada con ID: " + service.add(dto)
    );
}

public void update() {
    System.out.print("ID de la historia que quieres modificar: ");
    Long id = Long.parseLong(scanner.nextLine());

    System.out.print("Nuevo ID del paciente: ");
    Long pacienteId = Long.parseLong(scanner.nextLine());

    System.out.print("Nuevo ID del médico: ");
    Long medicoId = Long.parseLong(scanner.nextLine());

    System.out.print("Nuevo diagnóstico: ");
    String diagnostico = scanner.nextLine();

    System.out.print("Nueva fecha (AAAA-MM-DD): ");
    String fechaTexto = scanner.nextLine();

    LocalDate fecha = fechaTexto.isBlank()
            ? null
            : LocalDate.parse(fechaTexto);

    HistoriaClinicaDTO dto = HistoriaClinicaDTO.builder()
            .id(id)
            .pacienteId(pacienteId)
            .medicoId(medicoId)
            .diagnostico(diagnostico)
            .fechaAdmision(fecha)
            .build();

    service.update(dto);
    System.out.println("Historia actualizada.");
}

public void delete() {
    System.out.print("ID de la historia que quieres eliminar: ");
    Long id = Long.parseLong(scanner.nextLine());

    service.delete(id);
    System.out.println("Historia eliminada.");
}
}
