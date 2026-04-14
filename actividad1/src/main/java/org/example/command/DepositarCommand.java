package org.example.command;

import org.example.model.Persona;

import java.util.Scanner;

public class DepositarCommand implements Command{
    Persona persona;
    Scanner sc;

    public DepositarCommand(Persona persona, Scanner sc) {
        this.persona = persona;
        this.sc = sc;
    }

    @Override
    public Persona execute() {
        System.out.print("Monto: ");
        int monto = Integer.parseInt(sc.nextLine());
        persona.getCuenta().depositar(monto);

        return null;
    }
}
