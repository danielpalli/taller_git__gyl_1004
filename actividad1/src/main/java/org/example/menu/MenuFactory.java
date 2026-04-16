package org.example.menu;

import org.example.model.Banco;
import org.example.model.Persona;

import java.util.List;

public class MenuFactory {
    public static MenuStrategy crearMenu(Persona persona, Banco banco, List<Persona> personasRegistradas) {
        switch (persona.getRol()) {
            case CEO:
                return new MenuCeo(banco, personasRegistradas);
            case USUARIO:
                return new MenuUsuario(persona, banco);
            default:
                System.out.println("Rol no existente");
        }
        return null;
    }
}
