package org.example.command.administrativo;

import org.example.command.Command;
import org.example.model.Banco;
import org.example.model.Persona;
import org.example.model.Sucursal;

public class MostrarBalanceCommand implements Command {
    private Banco banco;

    public MostrarBalanceCommand(Banco banco) {
        this.banco = banco;
    }

    @Override
    public void execute() {
        for (Sucursal sucursal : this.banco.getSucursales()) {
            System.out.println("Sucursal: " + sucursal.getNombre());

            for (Persona persona : sucursal.getPersonas()) {
                persona.mostrarDatosPersona();
            }
        }
    }
}
