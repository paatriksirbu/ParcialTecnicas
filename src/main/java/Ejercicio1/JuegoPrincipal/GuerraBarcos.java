package Ejercicio1.JuegoPrincipal;
import Ejercicio1.Barco.Barco;
import Ejercicio1.Barco.Clima;
import Ejercicio1.Cuadricula.CuadriculaIA;
import Ejercicio1.EstrategiaPosicionamiento.EstrategiaPosicionamientoAleatorio;

import java.util.Scanner;

public class GuerraBarcos {
    public static void main(String[] args) throws InterruptedException {


        //Creamos tablero y lo mostramos
        System.out.println("Tablero inicial");
        CuadriculaIA cuadriculaIA = new CuadriculaIA();
        CuadriculaIA.mostrarTablero(cuadriculaIA);

        //Creamos un barco y lo depositamos en el tablero
        System.out.println("\nTablero con barco");
        Barco barco = new Barco(3, cuadriculaIA, 3, 3, Clima.VIENTO, new EstrategiaPosicionamientoAleatorio());
        cuadriculaIA.depositarBarco(3, 3, barco);
        CuadriculaIA.mostrarTablero(cuadriculaIA);

        while(true){    //Bucle que mueve el barco por el tablero simulando que hay corrientes marinas. Se mueve cada 2 segundos.
            barco.moverBarco();
            CuadriculaIA.mostrarTablero(cuadriculaIA);
            Thread.sleep(2500);

            Scanner sc = new Scanner(System.in);
            System.out.println("Introduzca la fila para disparar: ");
            int fila = sc.nextInt();
            System.out.println("Introduzca la columna para disparar: ");
            int columna = sc.nextInt();
            boolean hundido = barco.disparar(fila, columna);

            if (hundido){
                System.out.println("¡Has conseguido hundir el barco!");
                break;
            }
        }
    }
}