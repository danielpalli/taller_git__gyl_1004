package org.example;

import org.example.command.*;
import org.example.command.administrativo.MostrarBalanceCommand;
import org.example.command.administrativo.MostrarSucursalesCommand;
import org.example.command.autenticacion.CrearUsuarioCommand;
import org.example.command.usuario.CambiarSucursalCommand;
import org.example.command.usuario.DepositarCommand;
import org.example.command.usuario.RetirarCommand;
import org.example.command.usuario.TransferirCommand;
import org.example.model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco("Prueba");

        Persona persona = null;
        String opcion;

        do {
            System.out.println("1. Crear Banco");
            System.out.println("0. Continuar");

            opcion = sc.nextLine();

            if (opcion.equals("1")) {
                System.out.print("Nombre banco: ");
                String nombre = sc.nextLine();
                banco = new Banco(nombre);
            }

        } while (!opcion.equals("0"));

        do {
            System.out.println("1. Crear sucursal");
            System.out.println("0. Continuar");

            opcion = sc.nextLine();

            if (opcion.equals("1")) {
                System.out.print("Nombre sucursal: ");
                String nombre = sc.nextLine();

                if (banco.buscarSucursal(nombre) != null) {
                    System.out.println("Sucursal ya existe");
                } else {
                    banco.agregarSucursal(new Sucursal(nombre));
                    System.out.println("Sucursal creada");
                }
            }

        } while (!opcion.equals("0"));

        if (banco.getSucursales().isEmpty()) {
            System.out.println("No hay sucursales creadas. Fin.");
            sc.close();
            return;
        }

        Command mostrarSucursalesCommand = new MostrarSucursalesCommand(banco);
        Command crearUsuarioCommand = new CrearUsuarioCommand(sc);

        do {
            System.out.println("1. Crear persona");
            System.out.println("0. Continuar");

            opcion = sc.nextLine();

            if (opcion.equals("1")) {
                persona = crearUsuarioCommand.execute();

                System.out.println("Sucursales disponibles:");
                mostrarSucursalesCommand.execute();

                System.out.print("Elegir sucursal: ");
                String nombreSucursal = sc.nextLine();

                Sucursal sucursal = banco.buscarSucursal(nombreSucursal);

                if (sucursal != null) {
                    sucursal.agregarPersona(persona);
                    System.out.println("Persona agregada");
                } else {
                    System.out.println("Sucursal no existe");
                }
            }

        } while (!opcion.equals("0"));

        if (persona == null) {
            System.out.println("No hay personas creadas. Fin.");
            sc.close();
            return;
        }

        Command depositarCommand = new DepositarCommand(persona, sc);
        Command retirarCommand = new RetirarCommand(persona, sc);
        Command transferirCommand = new TransferirCommand(persona, banco, sc);
        Command cambiarSucursalCommand = new CambiarSucursalCommand();
        Command mostrarBalanceCommand = new MostrarBalanceCommand(banco);


        do {
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Transferir");
            System.out.println("4. Cambiar sucursal");
            System.out.println("5. Ver saldo");
            System.out.println("6. Ver sucursales");
            System.out.println("7. Balance banco");
            System.out.println("0. Salir");

            opcion = sc.nextLine();

            switch (opcion) {

                case "1":
                    depositarCommand.execute();
                    break;

                case "2":
                    retirarCommand.execute();
                    break;

                case "3":
                    transferirCommand.execute();
                    break;

                case "4":
                    // TODO falta implementacion
                    cambiarSucursalCommand.execute();
                    break;

                case "5":
                    // TODO implementar command
                    System.out.println("Saldo: " + persona.getCuenta().getSaldo());
                    break;

                case "6":
                    mostrarSucursalesCommand.execute();
                    break;

                case "7":
                    mostrarBalanceCommand.execute();
                    break;

                case "0":
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (!opcion.equals("0"));

        sc.close();
    }
}