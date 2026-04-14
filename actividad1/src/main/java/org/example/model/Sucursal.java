package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {
    private String nombre;
    private List<Persona> personas = new ArrayList<>();

    public Sucursal(String nombre) {
        this.nombre = nombre;
    }

    public void agregarPersona(Persona persona) {
        this.personas.add(persona);
    }
    public Persona buscarPersona(String nombre) {
        for (Persona persona : personas) {
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                return persona;
            }
        }
        return null;
    }
    public List<Persona> getPersonas() {
        return this.personas;
    }

    public String getNombre() {
        return this.nombre;
    }
}
