package org.example;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import org.example.ui.MainMenu;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Application {
    static void main() {
       //Lanzar la app
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()){
        //con esto inicializamos el contenedor

            MainMenu mainMenu = container.select(MainMenu.class).get();//lo rpimero a cargar es el objerto de la clase menu
            mainMenu.run();



        }
    }
}
