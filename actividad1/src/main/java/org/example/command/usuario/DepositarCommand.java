package org.example.command.usuario;

import org.example.command.Command;
import org.example.model.Persona;

public class DepositarCommand implements Command {
    private Persona persona;
    private int monto;

    public DepositarCommand(Persona persona, int monto) {
        this.persona = persona;
        this.monto = monto;
    }

    @Override
    public void execute() {
        persona.getCuenta().depositar(monto);
    }
}
