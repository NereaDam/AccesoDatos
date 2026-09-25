package org.example.dao.modelo;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Usuario {
    //clase que se mapea con la base de datos

    private String username;
    private String password;

}
