/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva3_9_gato;

import java.util.Scanner;

/**
 *
 * @author gerar
 */
public class EVA3_9_GATO {

    public static void main(String[] args) {
        // Tablero inicial
        char[][] tablero = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        char jugadorUno = 'X';
        boolean juegoTerminado = false;

        System.out.println("");
        imprimirTablero(tablero);

        while (!juegoTerminado) {
            System.out.println("Turno del jugador " + jugadorUno);
            int fila, columna;

          
            do {
                fila = obtenerEntrada("Introduce la fila (0, 1 o 2): ");
                columna = obtenerEntrada("Introduce la columna (0, 1 o 2): ");
            } while (!movimientoValido(tablero, fila, columna));

           
            tablero[fila][columna] = jugadorUno;
            imprimirTablero(tablero);

         
            if (verificarGanador(tablero, jugadorUno)) {
                System.out.println("El jugador " + jugadorUno+ " ha ganado!");
                juegoTerminado = true;
            } else if (tableroLleno(tablero)) {
                System.out.println("Empate");
                juegoTerminado = true;
            } else {
                
                jugadorUno = (jugadorUno == 'X') ? 'O' : 'X';
            }
        }
    }


    public static void imprimirTablero(char[][] tablero) {
        System.out.println("  0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.println("  " + tablero[i][0] + " | " + tablero[i][1] + " | " + tablero[i][2]);
            if (i < 2) System.out.println("|---|---|---|");
        }
    }

    public static boolean movimientoValido(char[][] tablero, int fila, int columna) {
        if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3) {
            System.out.println("Algo mal.");
            return false;
        }
        if (tablero[fila][columna] != ' ') {
            System.out.println("Ya ay algo ahi:");
            return false;
        }
        return true;
    }

   
    public static boolean verificarGanador(char[][] tablero, char jugador) {
        
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) {
                return true;
            }
        }
     
        for (int i = 0; i < 3; i++) {
            if (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador) {
                return true;
            }
        }
       
        if (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) {
            return true;
        }
        if (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador) {
            return true;
        }
        return false;
    }

    
    public static boolean tableroLleno(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    
    public static int obtenerEntrada(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Incorrecto. Introduce un numero.");
            System.out.print(mensaje);
            scanner.next();
        }
        return scanner.nextInt();
    }
}
    

