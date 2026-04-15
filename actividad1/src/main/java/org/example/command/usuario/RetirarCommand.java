package org.example.command.usuario;

import org.example.command.Command;
import org.example.model.Persona;

public class RetirarCommand implements Command {
    private Persona persona;
    private int monto;

    public RetirarCommand(Persona persona, int monto) {
        this.persona = persona;
        this.monto = monto;
    }

    @Override
    public void execute() {
        persona.getCuenta().retirar(monto);
    }
}
