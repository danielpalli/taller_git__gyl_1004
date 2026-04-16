package org.example.menu;

import org.example.command.usuario.DepositarCommand;
import org.example.command.usuario.RetirarCommand;
import org.example.command.usuario.TransferirCommand;
import org.example.model.Persona;
import org.example.model.Sucursal;

import java.util.Scanner;

public class MenuUsuario implements MenuStrategy{
    @Override
    public void mostrar() {
        System.out.println("1. Depositar");
        System.out.println("2. Retirar");
        System.out.println("3. Transferir");
        System.out.println("4. Saldo");
        System.out.println("0. Salir");
    }

    @Override
    public void manejarOpcion(String opcion, Scanner sc) {
        switch (opcion){
            case "1":
                System.out.print("Monto a depositar: ");
                int depositar = Integer.parseInt(sc.nextLine());
//                new DepositarCommand(persona, depositar).execute();
                break;
            case "2":
                System.out.print("Monto a retirar: ");
                int retirar = Integer.parseInt(sc.nextLine());
//                new RetirarCommand(persona, retirar).execute();
                break;
            case "3":
                System.out.print("Sucursal destino: ");
//                Sucursal sucursal = banco.buscarSucursal(sc.nextLine());
//                if (sucursal != null) {
//                    System.out.print("Nombre del destinatario: ");
//                    Persona destino = sucursal.buscarPersona(sc.nextLine());
//                    if (destino != null) {
//                        System.out.print("Monto a transferir: ");
//                        int monto = Integer.parseInt(sc.nextLine());
//                        new TransferirCommand(persona, destino, monto).execute();
//                    } else System.out.println("Destinatario no encontrado.");
//                } else System.out.println("Sucursal no encontrada.");
                break;
            case "4":
//                if(persona.getCuenta() != null) {
//                    System.out.println("Tu saldo actual es: " + persona.getCuenta().getSaldo());
//                } else {
//                    System.out.println("No tienes una cuenta activa.");
//                }
                break;

        }
    }
}
