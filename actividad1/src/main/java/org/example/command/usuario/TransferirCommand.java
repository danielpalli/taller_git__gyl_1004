package org.example.command.usuario;

import org.example.command.Command;
import org.example.model.Persona;

public class TransferirCommand implements Command {
    private Persona origen;
    private Persona destino;
    private int monto;

    public TransferirCommand(Persona origen, Persona destino, int monto) {
        this.origen = origen;
        this.destino = destino;
        this.monto = monto;
    }

    @Override
    public void execute() {
        if (destino != null) {
            this.origen.getCuenta().enviarDinero(destino.getCuenta(), monto);
        }
    }
}
