package org.example;

public class Persona {
    private String nombre;
    private String direccion;
    private String tipoCuenta;
    private int saldo;



    public Persona(String nombre, String direccion, String tipoCuenta) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipoCuenta = tipoCuenta;
        this.saldo = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public int getSaldo() {
        return saldo;
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
