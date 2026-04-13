package org.example;


public class Banco {
    private Persona[] personas;
    private int contador;
    public Banco(){
        this.personas = new Persona[0];
        this.contador= 0;
    }

    public void agregarPersona(Persona persona) {
        Persona[] nuevaPersona = new Persona[this.personas.length + 1];
        for(int i = 0; i < this.personas.length; i++) {
            nuevaPersona[i] = this.personas[i];
        }
        nuevaPersona[contador] = persona;

        this.personas = nuevaPersona;
        this.contador++;
    }

    public void mostrarPersonas() {
        for(int i = 0; i < this.contador; i++) {
            this.personas[i].mostrarDatosPersona();
        }
    }
}
