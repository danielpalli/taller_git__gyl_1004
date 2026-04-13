package org.example;

public class Persona {
    private String nombre;
    private String direccion;
    private Cuenta cuenta;

    private Persona(Builder builder) {
        this.nombre = builder.nombre;
        this.direccion = builder.direccion;
        this.cuenta = builder.cuenta;
    }

    public static class Builder {
        private String nombre;
        private String direccion;
        private Cuenta cuenta;

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }
        public Builder setDireccion(String direccion) {
            this.direccion = direccion;
            return this;
        }
        public Builder setCuenta(Cuenta cuenta) {
            this.cuenta = cuenta;
            return this;
        }

        public Persona build(){
            return new Persona(this);
        }
    }

    public void mostrarDatosPersona() {
        System.out.println("nombre: " + this.nombre);
        System.out.println("direccion: " + this.direccion);
        System.out.println("tipoCuenta: " + this.cuenta.getTipo());
        System.out.println("saldo: " + this.cuenta.getSaldo());
    }

    public Cuenta getCuenta(){
        return this.cuenta;
    }
}

