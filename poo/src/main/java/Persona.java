public class Persona {
    String nombre;
    int edad;
    String direccion;
    boolean puedeCaminar;
    boolean puedeVolar;
    boolean puedeHacerMagia;

    public void mostrarPersona(){

        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Direccion: " + direccion);

        System.out.println((puedeCaminar)? "Puede caminar: Si": "Puede caminar: No");
        System.out.println((puedeHacerMagia)? "Hace magia: Si": "Hace magia: No");
        System.out.println((puedeVolar)? "Puede volar: Si": "Puede volar: No");
    }
}
