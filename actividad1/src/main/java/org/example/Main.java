package org.example;

import org.example.enums.TipoCuenta;
import org.example.model.Banco;
import org.example.model.Cuenta;
import org.example.model.Persona;
import org.example.model.Sucursal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco();

        Persona persona = null;
        String opcion;

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

        do {
            System.out.println("1. Crear persona");
            System.out.println("0. Continuar");

            opcion = sc.nextLine();

            if (opcion.equals("1")) {
                persona = crearPersona(sc);

                System.out.println("Sucursales disponibles:");
                mostrarSucursales(banco);

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
                    depositar(sc, persona);
                    break;

                case "2":
                    retirar(sc, persona);
                    break;

                case "3":
                    transferir(sc, persona, banco);
                    break;

                case "4":
                    cambiarSucursal(sc, persona, banco);
                    break;

                case "5":
                    System.out.println("Saldo: " + persona.getCuenta().getSaldo());
                    break;

                case "6":
                    mostrarSucursales(banco);
                    break;

                case "7":
                    mostrarBalance(banco);
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

    public static Persona crearPersona(Scanner sc) {

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Direccion: ");
        String direccion = sc.nextLine();

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        System.out.print("Tipo cuenta (1: Caja Ahorro, 2: Corriente): ");
        String tipoInput = sc.nextLine();

        TipoCuenta tipo = tipoInput.equals("1") ?
            TipoCuenta.CAJA_AHORRO :
            TipoCuenta.CUENTA_CORRIENTE;

        Cuenta cuenta = new Cuenta(tipo);

        return new Persona.Builder()
            .setNombre(nombre)
            .setDireccion(direccion)
            .setCorreo(correo)
            .setCuenta(cuenta)
            .build();
    }

    public static void depositar(Scanner sc, Persona persona) {
        System.out.print("Monto: ");
        int monto = Integer.parseInt(sc.nextLine());
        persona.getCuenta().depositar(monto);
    }

    public static void retirar(Scanner sc, Persona persona) {
        System.out.print("Monto: ");
        int monto = Integer.parseInt(sc.nextLine());
        persona.getCuenta().retirar(monto);
    }

    public static void transferir(Scanner sc, Persona origen, Banco banco) {

        System.out.println("Sucursales disponibles:");
        mostrarSucursales(banco);

        System.out.print("Sucursal destino: ");
        String nombreSucursal = sc.nextLine();

        Sucursal sucursal = banco.buscarSucursal(nombreSucursal);

        if (sucursal == null) {
            System.out.println("Sucursal no existe");
            return;
        }

        System.out.print("Nombre destinatario: ");
        String nombre = sc.nextLine();

        Persona destino = sucursal.buscarPersona(nombre);

        if (destino == null) {
            System.out.println("No existe persona");
            return;
        }

        System.out.print("Monto: ");
        int monto = Integer.parseInt(sc.nextLine());

        origen.getCuenta().enviarDinero(destino.getCuenta(), monto);
    }

    public static void cambiarSucursal(Scanner sc, Persona persona, Banco banco) {

        System.out.println("Sucursales disponibles:");
        mostrarSucursales(banco);

        System.out.print("Sucursal destino: ");
        String nombreSucursal = sc.nextLine();

        Sucursal nuevaSucursal = banco.buscarSucursal(nombreSucursal);

        if (nuevaSucursal == null) {
            System.out.println("Sucursal no existe");
            return;
        }

        for (Sucursal sucursal : banco.getSucursales()) {
            if (sucursal.getPersonas().contains(persona)) {
                sucursal.getPersonas().remove(persona);
                nuevaSucursal.agregarPersona(persona);
                System.out.println("Cambio exitoso");
                return;
            }
        }
    }

    public static void mostrarSucursales(Banco banco) {
        for (Sucursal sucursal : banco.getSucursales()) {
            System.out.println(sucursal.getNombre());
        }
    }

    public static void mostrarBalance(Banco banco) {
        for (Sucursal sucursal : banco.getSucursales()) {
            System.out.println("Sucursal: " + sucursal.getNombre());

            for (Persona persona : sucursal.getPersonas()) {
                persona.mostrarDatosPersona();
            }
        }
    }
}