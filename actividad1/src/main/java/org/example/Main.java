package org.example;


public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Agustin", "Calle falsa 1", "Caja de ahorro");
        persona1.depositar(10);
        persona1.depositar(10);
        persona1.depositar(10);

        System.out.println("------------------------------");
        persona1.mostrarDatosPersona();
        System.out.println("------------------------------");

        Persona persona2 = new Persona("Martin", "Calle 13", "Cuenta corriente");
        persona2.depositar(22);
        persona2.depositar(22);
        persona2.depositar(2);
        System.out.println("------------------------------");
        persona2.mostrarDatosPersona();

        System.out.println("------------------------------");

        persona1.enviarDinero(persona2, 10);

        System.out.println("------------------------------");
        persona1.mostrarDatosPersona();

        System.out.println("------------------------------");

        persona2.mostrarDatosPersona();

        System.out.println("------------------------------");
    }
}