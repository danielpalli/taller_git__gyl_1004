package org.example.command.usuario;

import org.example.command.Command;
import org.example.model.Persona;

public class CambiarSucursalCommand implements Command {

    public CambiarSucursalCommand (){}

    @Override
    public Persona execute() {
        System.out.println("Cambiar sucursal: (No implementado)");
        return null;
    }
}
