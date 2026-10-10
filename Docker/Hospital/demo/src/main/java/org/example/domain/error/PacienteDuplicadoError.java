package org.example.domain.error;

import org.example.common.Constantes;

public class PacienteDuplicadoError  extends DatabaseError {
    public PacienteDuplicadoError() {
        super(Constantes.PACIENTE_DUPLICADO_ERROR);
    }
}
