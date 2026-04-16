package org.example.command.administrativo;

import org.example.command.Command;
import org.example.model.Persona;

import java.util.List;

public class VerPersonasRegistradasCommand implements Command {
    private List<Persona> personasRegistradas;

    public VerPersonasRegistradasCommand(List<Persona> personasRegistradas) {
        this.personasRegistradas = personasRegistradas;
    }

    @Override
    public void execute() {
        if (this.personasRegistradas.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        System.out.println("Personas registradas: ");
        for (Persona persona: this.personasRegistradas){
            System.out.println("    " + persona.getNombre());
        }
    }
}
