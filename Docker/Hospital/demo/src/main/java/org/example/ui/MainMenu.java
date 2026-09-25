package org.example.ui;

import jakarta.inject.Inject;
import org.example.dao.modelo.Usuario;

import java.util.Scanner;


public class MainMenu {

    private final UsuarioUi usuarioUi;

    @Inject
    public MainMenu(UsuarioUi usuarioUi){
        this.usuarioUi=usuarioUi;
    }


    public void run() {
        try {
            boolean logueado=false;
            Scanner read = new Scanner(System.in);
            System.out.println("Hospital app");
            System.out.println("Introduzca credenciales");

            while (!logueado){
                System.out.println("Usuario: ");
                String username = read.nextLine().trim();
                if (username.isEmpty()) continue;

                System.out.println("Contraseña: ");
                String password = read.nextLine().trim();
                if (password.isEmpty()) continue;

                Usuario credencialesUI = new Usuario(username,password);


                logueado = usuarioUi.login(credencialesUI);

            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
