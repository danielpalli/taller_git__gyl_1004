package org.example.model;


import org.example.enums.Rol;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nombre;
    private Persona ceo;
    private List<Sucursal> sucursales = new ArrayList<>();

    public void setCeo(Persona ceo) {
        if (ceo.getRol() == Rol.CEO) {
            this.ceo = ceo;
        } else {
            System.out.println("Error: La persona debe tener el rol de CEO");
        }
    }

    public Persona getCeo() {
        return this.ceo;
    }

    public Banco(String nombre) {
        this.nombre = nombre;
    }

    public void agregarSucursal(Sucursal sucursal) {
        this.sucursales.add(sucursal);
    }

    public Sucursal buscarSucursal(String nombre) {
        for (Sucursal sucursal : this.sucursales) {
            if (sucursal.getNombre().equalsIgnoreCase(nombre)) {
                return sucursal;
            }
        }
        return null;
    }

    public List<Sucursal> getSucursales() {
        return this.sucursales;
    }
}
