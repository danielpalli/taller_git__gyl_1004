package org.example.command.administrativo;

import org.example.command.Command;
import org.example.model.Banco;
import org.example.model.Sucursal;

public class MostrarSucursalesCommand implements Command {
    private Banco banco;

    public MostrarSucursalesCommand(Banco banco) {
        this.banco = banco;
    }

    @Override
    public void execute() {
        System.out.println(this.banco.getNombre() + " tiene sucurales: ");
        for (Sucursal sucursal : this.banco.getSucursales()) {
            System.out.println("    " + sucursal.getNombre());
        }
    }
}
