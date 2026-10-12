package org.example.dao.common;

public class SQLQueries {

    //Paciente
    public static final String FIND_ALL_PACIENTES = "SELECT * FROM pacientes";
    public static final String ADD_PACIENTE = "INSERT INTO pacientes (nombre, fecha_nacimiento, telefono) VALUES (?, ?, ?)";
public static final String UPDATE_PACIENTE="UPDATE pacientes\n" + "SET nombre = ?,\n" +
            "    fecha_nacimiento = ?,\n" + "    telefono = ?\n" + "WHERE paciente_id = ?;";
    public static final String DELETE_PACIENTE="DELETE FROM pacientes\n" + "WHERE paciente_id = ?;";

    //Usuarios

    public static final String FIND_USUARIO_BY_USERNAME = "SELECT * FROM usuarios WHERE username = ?";
    public static final String ADD_USUARIO = "INSERT INTO usuarios (username, password, paciente_id) VALUES (?, ?, ?)";

    //Medicos
    public static final String FIND_ALL_MEDICOS = "SELECT * FROM medicos";


    //HistoriaClinica
    public static final String FIND_HISTORIAS_BY_PACIENTE = "SELECT * FROM historia_clinica WHERE paciente_id = ?";

    public static final String ADD_HISTORIA = "INSERT INTO historia_clinica " +
                    "(paciente_id, medico_id, diagnostico, fecha_admision) " + "VALUES (?, ?, ?, ?)";

    public static final String UPDATE_HISTORIA = "UPDATE historia_clinica SET paciente_id = ?, " +
                    "medico_id = ?, diagnostico = ?, fecha_admision = ? " + "WHERE historia_id = ?";
    public static final String DELETE_HISTORIA="DELETE FROM historia_clinica\n" + "WHERE historia_id = ?;";


}
