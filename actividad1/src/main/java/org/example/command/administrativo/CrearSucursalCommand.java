package org.example.command.administrativo;

import org.example.command.Command;
import org.example.model.Banco;
import org.example.model.Sucursal;

public class CrearSucursalCommand implements Command {
    private Banco banco;
    private String nombreSucursal;

    public CrearSucursalCommand(Banco banco, String nombreSucursal) {
        this.banco = banco;
        this.nombreSucursal = nombreSucursal;
    }

    @Override
    public void execute() {
        Sucursal nuevaSucursal = new Sucursal(nombreSucursal);
        boolean agregado = this.banco.agregarSucursal(nuevaSucursal);
        String mensaje = agregado ?
                "Sucursal agregado correctamente": "Existe una sucursal con ese nombre";
        System.out.println(mensaje);
    }
}
