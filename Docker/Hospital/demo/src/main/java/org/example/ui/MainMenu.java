package org.example.ui;

import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.error.AppError;

@Slf4j
public class MainMenu {

    private static final int OPCION_LISTAR_PACIENTES = 1;
    private static final int OPCION_ANADIR_PACIENTE = 2;
    private static final int OPCION_ACTUALIZAR_PACIENTE = 3;
    private static final int OPCION_BORRAR_PACIENTE = 4;
    private static final int OPCION_LISTAR_MEDICOS = 5;
    private static final int OPCION_MOSTRAR_HISTORIA = 6;
    private static final int OPCION_ANADIR_REGISTRO = 7;
    private static final int OPCION_ACTUALIZAR_REGISTRO = 8;
    private static final int OPCION_BORRAR_REGISTRO = 9;
    private static final int OPCION_SALIR = 10;

    private final UsuarioUI usuarioUi;
    private final PacienteUI pacienteUi;
    private final MedicoUI medicoUi;
    private final HistoriaClinicaUI historiaClinicaUi;

    @Inject
    public MainMenu(
            UsuarioUI usuarioUi,
            PacienteUI pacienteUi,
            MedicoUI medicoUi,
            HistoriaClinicaUI historiaClinicaUi) {

        this.usuarioUi = usuarioUi;
        this.pacienteUi = pacienteUi;
        this.medicoUi = medicoUi;
        this.historiaClinicaUi = historiaClinicaUi;
    }

    public void run() {
        try {
            IO.println("=== Hospital App ===");

            usuarioUi.login();

            int opcion;

            do {
                printMenu();
                opcion = readOption();

                switch (opcion) {
                    case OPCION_LISTAR_PACIENTES:
                        pacienteUi.getAll();
                        break;

                    case OPCION_ANADIR_PACIENTE:
                        pacienteUi.save();
                        break;

                    case OPCION_ACTUALIZAR_PACIENTE:
                        pacienteUi.update();
                        break;

                    case OPCION_BORRAR_PACIENTE:
                        pacienteUi.delete();
                        break;

                    case OPCION_LISTAR_MEDICOS:
                        medicoUi.getAll();
                        break;

                    case OPCION_MOSTRAR_HISTORIA:
                        historiaClinicaUi.findByPacienteId();
                        break;

                    case OPCION_ANADIR_REGISTRO:
                        historiaClinicaUi.add();
                        break;

                    case OPCION_ACTUALIZAR_REGISTRO:
                        historiaClinicaUi.update();
                        break;

                    case OPCION_BORRAR_REGISTRO:
                        historiaClinicaUi.delete();
                        break;

                    case OPCION_SALIR:
                        IO.println("Hasta la vista.");
                        break;

                    default:
                        if (opcion != -1) {
                            IO.println("Opción no válida.");
                        }
                }

            } while (opcion != OPCION_SALIR);

        } catch (AppError e) {
            System.err.println("Fallo grave: " + e.getMessage());
            log.error("Fallo grave", e);
            System.exit(1);
        }
    }

    private void printMenu() {
        IO.println("\n=== Menú principal ===");
        IO.println(OPCION_LISTAR_PACIENTES + ". Mostrar todos los pacientes");
        IO.println(OPCION_ANADIR_PACIENTE + ". Añadir paciente");
        IO.println(OPCION_ACTUALIZAR_PACIENTE + ". Actualizar paciente");
        IO.println(OPCION_BORRAR_PACIENTE + ". Borrar paciente");
        IO.println(OPCION_LISTAR_MEDICOS + ". Mostrar todos los médicos");
        IO.println(OPCION_MOSTRAR_HISTORIA + ". Mostrar historia de un paciente");
        IO.println(OPCION_ANADIR_REGISTRO + ". Añadir registro a una historia");
        IO.println(OPCION_ACTUALIZAR_REGISTRO + ". Actualizar registro de una historia");
        IO.println(OPCION_BORRAR_REGISTRO + ". Borrar registro de una historia");
        IO.println(OPCION_SALIR + ". Salir");
        IO.println("Introduzca una opción:");
    }

    private int readOption() {
        String linea = IO.readln();

        if (linea == null || linea.trim().isEmpty()) {
            IO.println("Debe introducir una opción.");
            return -1;
        }

        try {
            return Integer.parseInt(linea.trim());
        } catch (NumberFormatException e) {
            IO.println("Opción no válida. Debe introducir un número.");
            return -1;
        }
    }
}
