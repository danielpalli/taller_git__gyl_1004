package org.example.command;

import org.example.model.Banco;
import org.example.model.Persona;
import org.example.model.Sucursal;

public class MostrarSucursalesCommand implements Command {
    private Banco banco;

    public MostrarSucursalesCommand(Banco banco) {
        this.banco = banco;
    }

    @Override
    public Persona execute() {
        for (Sucursal sucursal : this.banco.getSucursales()) {
            System.out.println(sucursal.getNombre());
        }
        return null;
    }
}
