package org.example;


public class Main {
    public static void main(String[] args) {

        Banco banco1 = new Banco();
        Banco banco2 = new Banco();
        Cuenta cuantaCorriente1 = new Cuenta("Cuenta corriente");
        Cuenta cuantaCorriente2 = new Cuenta("Cuenta corriente");

        Persona persona1 = new Persona.Builder().setDireccion("Calle falsa 1").setNombre("Agustin").setCuenta(cuantaCorriente1).build();
        persona1.getCuenta().depositar(10);
        persona1.getCuenta().depositar(10);
        persona1.getCuenta().depositar(10);

        persona1.mostrarDatosPersona();

        Persona persona2 = new Persona.Builder().setDireccion("Calle 13").setNombre("Martin").setCuenta(cuantaCorriente2).build();
        persona2.getCuenta().depositar(2);
        System.out.println("------------------------------");
        persona2.mostrarDatosPersona();
        System.out.println("------------------------------");
        persona1.getCuenta().enviarDinero(persona2.getCuenta(), 22);

        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("------------------------------");

        banco1.agregarPersona(persona1);
        banco1.agregarPersona(persona2);

        banco1.mostrarPersonas();
        System.out.println("------------------------------");

        banco2.mostrarPersonas();
    }
}