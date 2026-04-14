package org.example.command;

import org.example.model.Banco;
import org.example.model.Persona;
import org.example.model.Sucursal;

import java.util.Scanner;

public class TransferirCommand implements Command {
    Persona persona;
    Scanner sc;
    Banco banco;

    public TransferirCommand(Persona persona, Banco banco, Scanner sc) {
        this.persona = persona;
        this.banco = banco;
        this.sc = sc;
    }

    @Override
    public Persona execute() {
        System.out.print("Sucursal destino: ");
        String nombreSucursal = sc.nextLine();

        Sucursal sucursal = this.banco.buscarSucursal(nombreSucursal);

        if (sucursal == null) {
            System.out.println("Sucursal no existe");
            return null;
        }

        System.out.print("Nombre destinatario: ");
        String nombre = sc.nextLine();

        Persona destino = sucursal.buscarPersona(nombre);

        if (destino == null) {
            System.out.println("No existe persona");
            return destino;
        }

        System.out.print("Monto: ");
        int monto = Integer.parseInt(sc.nextLine());

        this.persona.getCuenta().enviarDinero(destino.getCuenta(), monto);
        return destino;
    }
}
