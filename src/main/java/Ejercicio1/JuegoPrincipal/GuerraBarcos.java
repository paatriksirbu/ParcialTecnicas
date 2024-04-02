package Ejercicio1.JuegoPrincipal;
import Ejercicio1.Barco.Barco;
import Ejercicio1.Barco.Clima;
import Ejercicio1.Cuadricula.CuadriculaIA;
import Ejercicio1.EstrategiaPosicionamiento.EstrategiaPosicionamientoAleatorio;
import Ejercicio1.Factory.FabricaBarcos;

import java.util.Scanner;

public class GuerraBarcos {
    public static void main(String[] args) throws InterruptedException {


        //Creamos tablero y lo mostramos
        System.out.println("Tablero inicial");
        CuadriculaIA cuadriculaIA = new CuadriculaIA();
        CuadriculaIA.mostrarTablero(cuadriculaIA);

        System.out.println("\n Que tipo de barco quieres crear?");
        System.out.println("1. Barco Battleship (5 casillas)");
        System.out.println("1. Barco Frigate (3 casillas)");
        System.out.println("1. Barco Canoe (1 casilla)");
        Scanner sc = new Scanner(System.in);
        int tipoBarco = sc.nextInt();

        Barco barco = null;
        switch (tipoBarco){
            case 1:
                FabricaBarcos fabricaBarcos1 = new FabricaBarcos(cuadriculaIA, 3, 3, Clima.VIENTO, new EstrategiaPosicionamientoAleatorio());
                Barco barco1 = fabricaBarcos1.crearBattleship();
                cuadriculaIA.depositarBarco(3, 3, barco1);
                break;
            case 2:
                FabricaBarcos fabricaBarcos2 = new FabricaBarcos(cuadriculaIA, 3, 3, Clima.VIENTO, new EstrategiaPosicionamientoAleatorio());
                Barco barco2 = fabricaBarcos2.crearFrigate();
                cuadriculaIA.depositarBarco(3, 3, barco2);
                break;
            case 3:
                FabricaBarcos fabricaBarcos3 = new FabricaBarcos(cuadriculaIA, 3, 3, Clima.VIENTO, new EstrategiaPosicionamientoAleatorio());
                Barco barco3 = fabricaBarcos3.crearCanoe();
                cuadriculaIA.depositarBarco(3, 3, barco3);
                break;
            default:
                System.out.println("Opcion no valida");
        }

        if (barco == null){
            System.out.println("No se ha creado ningun barco");
            return;
        }

        //Creamos un barco y lo depositamos en el tablero
        System.out.println("\nTablero con barco");
        CuadriculaIA.mostrarTablero(cuadriculaIA);

        while(true){    //Bucle que mueve el barco por el tablero simulando que hay corrientes marinas. Se mueve cada 2 segundos.
            barco.moverBarco();
            CuadriculaIA.mostrarTablero(cuadriculaIA);
            Thread.sleep(2500);

            sc = new Scanner(System.in);
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