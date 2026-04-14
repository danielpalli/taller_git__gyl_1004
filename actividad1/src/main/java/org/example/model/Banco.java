package org.example.model;


import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Sucursal> sucursales = new ArrayList<>();

    public void agregarSucursal(Sucursal sucursal) {
        sucursales.add(sucursal);
    }

    public Sucursal buscarSucursal(String nombre) {
        for (Sucursal sucursal : sucursales) {
            if (sucursal.getNombre().equalsIgnoreCase(nombre)) {
                return sucursal;
            }
        }
        return null;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }
}
