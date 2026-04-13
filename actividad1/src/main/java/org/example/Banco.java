package org.example;

import java.util.ArrayList;

public class Banco {
    private ArrayList<Persona> personas = new ArrayList<>();

    public void agregarPersona(Persona persona) {
        personas.add(persona);
    }

    public void mostrarPersonas() {
        if(this.personas.isEmpty()) {
            System.out.println("El banco no cuenta con clientes");
            return;
        };

        for(Persona persona: this.personas) {
            persona.mostrarDatosPersona();
        }
    }
}
