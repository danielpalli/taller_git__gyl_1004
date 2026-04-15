package org.example;

import org.example.command.*;
import org.example.command.administrativo.MostrarBalanceCommand;
import org.example.command.administrativo.MostrarSucursalesCommand;
import org.example.command.usuario.DepositarCommand;
import org.example.command.usuario.RetirarCommand;
import org.example.command.usuario.TransferirCommand;
import org.example.enums.Rol;
import org.example.enums.TipoCuenta;
import org.example.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Persona ceo = new Persona.Builder()
            .setNombre("Agustin")
            .setDireccion("Calle Admin 1")
            .setCorreo("test")
            .setCuenta(new Cuenta(TipoCuenta.CUENTA_CORRIENTE))
            .setPassword("123")
            .setRol(Rol.CEO)
            .build();

        ceo.mostrarDatosPersona();

        Banco banco = new Banco("Prueba");
        banco.setCeo(ceo);
        System.out.println("El CEO del banco es: " + banco.getCeo().getNombre());

        List<Persona> personasRegistradas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        personasRegistradas.add(ceo);

        Persona personaLogueada = iniciarSecion(sc, personasRegistradas);

        if (personaLogueada == null) return;

        System.out.println("Conectado: " + personaLogueada.getNombre());

        if (personaLogueada.getRol() == Rol.CEO) {
            menuCeo(sc, banco);
        } else {
            menuUsuario(sc, personaLogueada, banco);
        }

        sc.close();
    }

    private static Persona iniciarSecion(Scanner sc, List<Persona> personas) {
        Persona personaLogueada = null;
        String opcion;
        do {
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesion");
            System.out.println("0. Salir");
            opcion = sc.nextLine();

            if (opcion.equals("1")) {
                registrarNuevoUsuario(sc, personas);
            }

            if (opcion.equals("2")) {
                System.out.print("Correo: "); String cor = sc.nextLine();
                System.out.print("Password: "); String pass = sc.nextLine();

                for (Persona p : personas) {
                    if (p.getCorreo().equals(cor) && p.getPassword().equals(pass)) {
                        personaLogueada = p;
                        break;
                    }
                }
                if (personaLogueada == null) System.out.println("Credenciales incorrectas.");
            }
        } while (personaLogueada == null && !opcion.equals("0"));

        return personaLogueada;
    }

    private static void registrarNuevoUsuario (Scanner sc, List<Persona> personas) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        System.out.print("Direccion: ");
        String direccion = sc.nextLine();
        System.out.println("Seleccione tipo de cuenta:");
        System.out.println("1. Caja de Ahorro");
        System.out.println("2. Cuenta Corriente");
        String tipoCuenta = sc.nextLine();

        TipoCuenta tipo = tipoCuenta.equals("1") ?
                TipoCuenta.CUENTA_CORRIENTE : TipoCuenta.CAJA_AHORRO;

        Cuenta nuevaCuenta = new Cuenta(tipo);

        Persona nuevoUsuario = new Persona.Builder()
                .setNombre(nombre)
                .setCorreo(correo)
                .setDireccion(direccion)
                .setPassword(password)
                .setRol(Rol.USUARIO)
                .setCuenta(nuevaCuenta)
                .build();

        personas.add(nuevoUsuario);
        System.out.println("Usuario registrado");
    }

    private static void menuCeo(Scanner sc, Banco banco) {
        String opcion;
        Command mostrarSucursales = new MostrarSucursalesCommand(banco);
        Command mostrarBalance = new MostrarBalanceCommand(banco);

        do {
            System.out.println("1. Crear nueva sucursal");
            System.out.println("2. Ver todas las sucursales");
            System.out.println("3. Ver balance general");
            System.out.println("0. Salir");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre de la sucursal: ");
                    String nombreSucursal = sc.nextLine();
                    banco.agregarSucursal(new Sucursal(nombreSucursal));
                    System.out.println("Sucursal '" + nombreSucursal + "' creada.");
                    break;
                case "2":
                    mostrarSucursales.execute();
                    break;
                case "3":
                    mostrarBalance.execute();
                    break;
            }
        } while (!opcion.equals("0"));
    }

    private static void menuUsuario(Scanner sc, Persona persona, Banco banco) {
        String opcion;
        do {
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Transferir");
            System.out.println("4. Saldo");
            System.out.println("0. Salir");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Monto a depositar: ");
                    int depositar = Integer.parseInt(sc.nextLine());
                    new DepositarCommand(persona, depositar).execute();
                    break;
                case "2":
                    System.out.print("Monto a retirar: ");
                    int retirar = Integer.parseInt(sc.nextLine());
                    new RetirarCommand(persona, retirar).execute();
                    break;
                case "3":
                    System.out.print("Sucursal destino: ");
                    Sucursal sucursal = banco.buscarSucursal(sc.nextLine());
                    if (sucursal != null) {
                        System.out.print("Nombre del destinatario: ");
                        Persona destino = sucursal.buscarPersona(sc.nextLine());
                        if (destino != null) {
                            System.out.print("Monto a transferir: ");
                            int monto = Integer.parseInt(sc.nextLine());
                            new TransferirCommand(persona, destino, monto).execute();
                        } else System.out.println("Destinatario no encontrado.");
                    } else System.out.println("Sucursal no encontrada.");
                    break;
                case "4":
                    if(persona.getCuenta() != null) {
                        System.out.println("Tu saldo actual es: " + persona.getCuenta().getSaldo());
                    } else {
                        System.out.println("No tienes una cuenta activa.");
                    }
                    break;
            }
        } while (!opcion.equals("0"));
    }
}