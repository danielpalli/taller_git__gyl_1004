package org.example.command.administrativo;

import org.example.command.Command;
import org.example.enums.Rol;
import org.example.model.Banco;
import org.example.model.Persona;
import org.example.model.Sucursal;

import java.awt.image.BufferStrategy;
import java.util.List;

public class AsignarAdminASucursalCommand implements Command  {
    private Banco banco;
    private List<Persona> personasRegistradas;
    private String nombreSucursal;
    private String correo;

    public AsignarAdminASucursalCommand(Banco banco, List<Persona> personasRegistradas, String nombreSucursal, String correo) {
        this.banco = banco;
        this.personasRegistradas = personasRegistradas;
        this.nombreSucursal = nombreSucursal;
        this.correo = correo;
    }

    @Override
    public void execute() {
        Sucursal sucursal = this.banco.buscarSucursal(nombreSucursal);
        if (sucursal == null){
            System.out.println("Sucursal no existe");
            return;
        }

        if (sucursal.tieneAdmin()) {
            System.out.println("La sucursal ya tiene admin");
            return;
        }

        Persona buscarPersona = null;

        for (Persona persona: this.personasRegistradas) {
            if (persona.getCorreo().equalsIgnoreCase(this.correo)){
                buscarPersona = persona;
                break;
            }
        }

        if (buscarPersona == null) {
            System.out.println("Persona no encontrada");
            return;
        }

        if (buscarPersona.getRol() == Rol.CEO) {
            System.out.println("El usuario es ceo");
            return;
        }

        if (buscarPersona.getRol() == Rol.ADMIN) {
            System.out.println("El usuario ya es admin");
            return;
        }

        buscarPersona.setRol(Rol.ADMIN);
        System.out.println("El usuario " + buscarPersona.getNombre() + "es admin de la sucursal " + sucursal.getNombre());
    }

}
