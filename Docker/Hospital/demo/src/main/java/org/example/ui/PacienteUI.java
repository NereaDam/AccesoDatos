package org.example.ui;

import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.dto.PacienteDTO;
import org.example.domain.dto.PacienteDTOAlta;
import org.example.domain.error.AppError;
import org.example.domain.error.DatabaseError;
import org.example.domain.service.PacienteService;

import java.time.LocalDate;
import java.util.Scanner;

@Slf4j
public class PacienteUI {
    private final PacienteService pacienteService;
    private final Scanner scanner;
    @Inject
    public PacienteUI (PacienteService pacienteService) {
        this.pacienteService = pacienteService;
        this.scanner = new Scanner(System.in);
    }

    public void getAll() {
        try {
            IO.println(pacienteService.getAll());
        } catch (DatabaseError e) {
            log.error("Error de BD {}", e.getMessage());
        } catch (Exception e) {
            log.error("Error inesperado");
            throw new AppError("Error crítico");
        }
    }

    public void save() {
        try {
            PacienteDTOAlta pacienteDTO = PacienteDTOAlta.builder()
                    .nombre("Mario")
                    .fechaNacimiento(LocalDate.of(2003, 10, 23))
                    .telefono("690 555 777")
                    .username("mario")
                    .password("1234")
                    .build();
            IO.println(pacienteService.add(pacienteDTO));
        } catch (DatabaseError e) {
            log.error("Error de base de datos en PatientService.addPatient()");
        } catch (Exception e) {
            log.error("Error inesperado", e);
            throw new AppError("Error crítico en addPatient()");
        }
    }

    public void update() {
        try {
            System.out.print("ID del paciente que quieres modificar: ");
            Long id = Long.parseLong(scanner.nextLine());

            System.out.print("Nuevo nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Nueva fecha de nacimiento (AAAA-MM-DD): ");
            String fechaTexto = scanner.nextLine();
            LocalDate fecha = fechaTexto.isBlank() ? null : LocalDate.parse(fechaTexto);

            System.out.print("Nuevo teléfono: ");
            String telefono = scanner.nextLine();

            PacienteDTO dto = PacienteDTO.builder()
                    .id(id)
                    .nombre(nombre)
                    .fechaNacimiento(fecha)
                    .telefono(telefono)
                    .build();

            pacienteService.update(dto);
            IO.println("Paciente actualizado.");
        } catch (DatabaseError e) {
            log.error("Error de BD {}", e.getMessage());
        } catch (Exception e) {
            log.error("Error inesperado", e);
            throw new AppError("Error crítico en update()");
        }
    }

    public void delete() {
        try {
            System.out.print("ID del paciente a eliminar: ");
            Long id = Long.parseLong(new Scanner(System.in).nextLine());
            pacienteService.delete(id);
            IO.println("Paciente eliminado.");
        } catch (DatabaseError e) {
            log.error("Error de BD {}", e.getMessage());
        }
    }




}