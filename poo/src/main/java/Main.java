public class Main {
    public static void main(String[] args) {

        Persona objPersona1 = new Persona();
        objPersona1.nombre = "Agustin";
        objPersona1.edad = 20;
        objPersona1.direccion = "Calle falsa 123";
        objPersona1.puedeVolar = true;
        objPersona1.puedeHacerMagia = true;
        objPersona1.puedeCaminar = false;

        objPersona1.mostrarPersona();

        System.out.println("-------------------------------------------");

        Persona objPersona2 = new Persona();
        objPersona2.nombre = "Martin";
        objPersona2.edad = 23;
        objPersona2.direccion = "Calle Verdadera 123";
        objPersona2.puedeVolar = false;
        objPersona2.puedeHacerMagia = false;
        objPersona2.puedeCaminar = true;

        objPersona2.mostrarPersona();

        System.out.println("-------------------------------------------");

        Persona objPersona3 = new Persona();
        objPersona3.nombre = "Pablo";
        objPersona3.edad = 35;
        objPersona3.direccion = "Calle inversa 123";
        objPersona3.puedeVolar = true;
        objPersona3.puedeHacerMagia = true;
        objPersona3.puedeCaminar = true;

        objPersona3.mostrarPersona();
    }
}

