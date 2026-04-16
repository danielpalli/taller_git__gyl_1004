package org.example.command.usuario;

import org.example.command.Command;
import org.example.model.Banco;
import org.example.model.Persona;
import org.example.model.Sucursal;

public class TransferirCommand implements Command {
    private Persona origen;
    private Banco banco;
    private String nombreSucursal;
    private String nombreDestinatario;
    private int monto;

    public TransferirCommand(Persona origen, Banco banco, String nombreSucursal, String nombreDestinatario, int monto) {
        this.origen = origen;
        this.banco = banco;
        this.nombreSucursal = nombreSucursal;
        this.nombreDestinatario = nombreDestinatario;
        this.monto = monto;
    }

    @Override
    public void execute() {
        Sucursal sucursal = this.banco.buscarSucursal(this.nombreSucursal);
        if (sucursal == null) {
            System.out.println("Sucursal no encontrada");
            return;
        }
        Persona destino = sucursal.buscarPersona(this.nombreDestinatario);

        if (destino == null) {
            System.out.println("Destinatario no encontrado");
            return;
        }

        this.origen.getCuenta().enviarDinero(destino.getCuenta(), this.monto);
    }
}
