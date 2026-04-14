package org.example.model;


import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nombre;
    private List<Sucursal> sucursales = new ArrayList<>();

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
