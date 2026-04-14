package org.example.command.usuario;

import org.example.command.Command;
import org.example.model.Persona;

import java.util.Scanner;

public class RetirarCommand implements Command {
    Persona persona;
    Scanner sc;

    public RetirarCommand(Persona persona, Scanner sc){
        this.persona = persona;
        this.sc = sc;
    }

    @Override
    public Persona execute() {
        System.out.print("Monto: ");
        int monto = Integer.parseInt(sc.nextLine());
        persona.getCuenta().retirar(monto);
        return null;
    }
}
