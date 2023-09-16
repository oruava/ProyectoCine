package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [][] salaCine;
        System.out.println("Ingrese su usuario: ");
        String user = scanner.next();
        System.out.println("Ingrese su contraseña: ");
        String password = scanner.next();
        System.out.println(inicioSesion(user, password));
        salaCine = generarSaladeCine(15,15);
        mostrarAsientosdeCine(salaCine);
        comprarTicket(salaCine);
        mostrarAsientosdeCine(salaCine);

    }
    public static boolean inicioSesion(String user, String password){
        String usuario = "Carlos";
        String clave = "admincine123";
        if (usuario.equals(user) && password.equals(clave)){
            return true;
        }
        System.out.println("Las credenciales son incorrectas");
        return false;
    }
    public static String[][] generarSaladeCine(int filas, int columnas) {
        String[][] matriz = new String[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = (j + 1) + Character.toString((char) ('a' + i));
            }
        }
        return matriz;
    }
    public static void mostrarAsientosdeCine(String[][] matriz) {
        System.out.println("Los asientos disponibles son: ");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("|" + matriz[i][j] + "|");
            }
            System.out.println();
        }
    }
    public static void comprarTicket(String[][] matriz) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la columna del asiento que desea comprar (número): ");
        int columna = scanner.nextInt();
        System.out.println("Ingrese la fila del asiento que desea comprar (letra): ");
        char fila = scanner.next().charAt(0);

                                    // Verificar si las coordenadas son válidas
        if (columna >= 1 && columna <= matriz.length && fila >= 'a' && fila < 'a' + matriz[0].length) {
                                    // Convertir la fila a índice de matriz
            int columnaIndex = columna - 1;
            int filaIndex = fila - 'a';

            if (matriz[filaIndex][columnaIndex] != "X") {
                matriz[filaIndex][columnaIndex] = "X"; // Marcar el asiento como ocupado
                System.out.println("¡Compra exitosa! Ha comprado el asiento " + columna + fila);
            } else {
                System.out.println("Este asiento ya está ocupado. Por favor, seleccione otro.");
            }
        } else {
            System.out.println("Ubicación de asiento no válida. Por favor, ingrese una ubicación válida.");
        }
    }

}


