package org.example;

public class BuilderPersona {
    private String nombre;
    private String direccion;
    private String tipoCuenta;

    public BuilderPersona setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public BuilderPersona setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }
    public BuilderPersona setTipoDeCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
        return this;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getDireccion(){
        return this.direccion;
    }

    public String getTipoDeCuenta(){
        return this.tipoCuenta;
    }

    public Persona build(){
        return new Persona(this);
    }

}