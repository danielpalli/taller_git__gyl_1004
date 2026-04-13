package org.example;

public class Persona {
    private String nombre;
    private String direccion;
    private String tipoCuenta;
    private int saldo;

    private Persona(Builder builder) {
        this.nombre = builder.nombre;
        this.direccion = builder.direccion;
        this.tipoCuenta = builder.tipoCuenta;
        this.saldo = 0;
    }

    public static class Builder {
        private String nombre;
        private String direccion;
        private String tipoCuenta;

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }
        public Builder setDireccion(String direccion) {
            this.direccion = direccion;
            return this;
        }
        public Builder setTipoDeCuenta(String tipoCuenta) {
            this.tipoCuenta = tipoCuenta;
            return this;
        }


        public Persona build(){
            return new Persona(this);
        }

    }

    public void depositar(int monto) {
        if (monto > 0) this.saldo += monto;
        System.out.println("Dinero depositado: " + monto);
        System.out.println("Saldo actual: " + this.saldo);
    }

    public void enviarDinero(Persona destino, int monto) {
        if (monto > 0 && this.saldo >= monto) {
            saldo -= monto;
            destino.depositar(monto);
            System.out.println("Dinero enviado correctamente.");
            return;
        }

        System.out.println("No se puedo enviar el dinero, verifique bien los datos");
    }

    public void mostrarDatosPersona() {
        System.out.println("nombre: " + this.nombre);
        System.out.println("direccion: " + this.direccion);
        System.out.println("tipoCuenta: " + this.tipoCuenta);
        System.out.println("saldo: " + this.saldo);
    }
}

