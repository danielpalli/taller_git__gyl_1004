package org.example;


public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona.Builder().setDireccion("Calle falsa 1").setNombre("Agustin").setTipoDeCuenta("Cuenta corriente").build();
        persona1.depositar(10);
        persona1.depositar(10);
        persona1.depositar(10);


        persona1.mostrarDatosPersona();




        Persona persona2 = new Persona.Builder().setDireccion("Calle 13").setNombre("Martin").setTipoDeCuenta("Cuenta corriente").build();
        persona1.enviarDinero(persona2, 20);

        persona2.mostrarDatosPersona();
        persona1.mostrarDatosPersona();
    }
}