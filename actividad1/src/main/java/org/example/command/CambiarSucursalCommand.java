package org.example.command;

import org.example.model.Persona;

public class CambiarSucursalCommand implements Command {

    public CambiarSucursalCommand (){}

    @Override
    public Persona execute() {
        System.out.println("Cambiar sucursal: (No implementado)");
        return null;
    }
}
