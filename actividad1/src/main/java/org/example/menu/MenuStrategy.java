package org.example.menu;

import java.util.Scanner;

public interface MenuStrategy {
    void mostrar();
    void manejarOpcion(String opcion, Scanner sc);
}
