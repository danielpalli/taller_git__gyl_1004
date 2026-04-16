package org.example.command.usuario;

import org.example.command.Command;
import org.example.model.Persona;

public class VerSaldoCommand implements Command {
    private Persona persona;

    public VerSaldoCommand(Persona persona) {
        this.persona = persona;
    }

    @Override
    public void execute() {
        System.out.println("Tu saldo actual es :" + this.persona.getCuenta().getSaldo());
    }
}
