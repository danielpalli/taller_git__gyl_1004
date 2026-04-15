package org.example.command.administrativo;

import org.example.command.Command;
import org.example.model.Persona;
import org.example.model.Sucursal;

import java.util.List;

public class VerUsuariosRegistradosCommand implements Command {
    private List<Persona> personasRegistradas;

    public VerUsuariosRegistradosCommand(List<Persona> personasRegistradas) {
        this.personasRegistradas = personasRegistradas;
    }

    @Override
    public void execute() {
        if (this.personasRegistradas.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        System.out.println("Usuarios: ");
        for (Persona persona: this.personasRegistradas){
            System.out.println("    " + persona.getNombre());
        }
    }
}
