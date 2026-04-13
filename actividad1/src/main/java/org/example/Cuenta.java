package org.example;

public class Cuenta {
    private String tipo;
    private int saldo;

    public Cuenta(String tipo) {
        this.tipo = tipo;
        this.saldo = 0;
    }

    public void depositar(int monto) {
        if (monto > 0) this.saldo += monto;
    }


    public void enviarDinero(Cuenta destino, int monto) {
        if (monto > 0 && this.saldo >= monto) {
            saldo -= monto;
            destino.depositar(monto);
            System.out.println("Dinero enviado correctamente. Por un monto de: " + monto);
            return;
        }
        System.out.println("No se puedo enviar el dinero, verifique bien los datos");
    }

    public int getSaldo() {
        return saldo;
    }
    public String getTipo(){
        return tipo;
    }
}
