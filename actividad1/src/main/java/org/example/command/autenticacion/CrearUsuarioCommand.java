package org.example.command.autenticacion;

import org.example.command.Command;
import org.example.enums.TipoCuenta;
import org.example.model.Cuenta;
import org.example.model.Persona;

import java.util.Scanner;

public class CrearUsuarioCommand implements Command {
    private Scanner sc;

    public CrearUsuarioCommand(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public Persona execute() {

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
}
