package org.example;


public class Main {
    public static void main(String[] args) {
        BuilderPersona builder1 = new BuilderPersona();

        Persona persona1 = builder1.setDireccion("Calle falsa 1").setNombre("Agustin").setTipoDeCuenta("Cuenta corriente").build();
        persona1.depositar(10);
        persona1.depositar(10);
        persona1.depositar(10);


        persona1.mostrarDatosPersona();


        BuilderPersona builder2 = new BuilderPersona();


        Persona persona2 = builder2.setDireccion("Calle 13").setNombre("Martin").setTipoDeCuenta("Cuenta corriente").build();
        persona1.enviarDinero(persona2, 20);

        persona2.mostrarDatosPersona();
        persona1.mostrarDatosPersona();
    }
}