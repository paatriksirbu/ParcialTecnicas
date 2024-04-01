package Ejercicio1.Barco;

import Ejercicio1.Cuadricula.CuadriculaIA;
import Ejercicio1.EstrategiaPosicionamiento.EstrategiaPosicionamiento;

import java.util.Random;

public class Barco implements IntBarco{
    private int tamano;
    private boolean golpeado;
    private CuadriculaIA cuadriculaIA;
    private int filaActual;
    private int columnaActual;
    private Clima clima;
    private EstrategiaPosicionamiento estrategia;


    public Barco(int tamano, CuadriculaIA cuadriculaIA, int filaInicial, int columnaInicial, Clima clima, EstrategiaPosicionamiento estrategia) {
        this.tamano = tamano;
        this.golpeado = false;
        this.cuadriculaIA = cuadriculaIA;
        this.filaActual = filaInicial;
        this.columnaActual = columnaInicial;
        this.clima = clima;
        this.estrategia = estrategia;
        estrategia.posicionarBarco(cuadriculaIA, this);
    }

    public int getTamano() {
        return tamano;
    }

    public boolean isGolpeado() {
        return golpeado;
    }

    public void golpear() {
        this.golpeado = true;
    }

    //Creamos un metodo que haga que el barco se mueva segun la situacion ambiental. Entendiendo que puede haber viento y corrientes marinas,
    //el barco se podra mover aleatoriamente en cualquier direccion (arriba, abajo, izquierda, derecha), siempre en posiciones adyacentes..
    public void moverBarco(){
        Random random = new Random();
        int direccion;


        int filaActual = -1, columnaActual = -1;
        for (int i = 0; i < cuadriculaIA.getNumFilas(); i++) {
            for (int j = 0; j < cuadriculaIA.getNumColumnas(); j++) {
                if (cuadriculaIA.getCuadricula()[i][j] == 'B') {
                    filaActual = i;
                    columnaActual = j;
                    break;
                }
            }
        }

        int nuevaFila = filaActual, nuevaColumna = columnaActual;
        int posiciones;
        switch (clima){
            case VIENTO:
                posiciones = 2;
                break;
            case TORMENTA:
                posiciones = 2 + random.nextInt(2);
                break;
            case TSUNAMI:
                posiciones = 3 + random.nextInt(2);
                break;
            case CALMA:
            default:
                posiciones = 1;
        }

        for (int i = 0; i < posiciones; i++){
            do{
                direccion = random.nextInt(4);
                nuevaFila = filaActual;
                nuevaColumna = columnaActual;
                switch (direccion) {
                    case 0: //Arriba
                        nuevaFila--;
                        break;
                    case 1: //Derecha
                        nuevaColumna++;
                        break;
                    case 2: //Abajo
                        nuevaFila++;
                        break;
                    case 3: //Izquierda
                        nuevaColumna--;
                        break;
                }
            } while(nuevaFila < 0 || nuevaFila >= cuadriculaIA.getNumFilas() || nuevaColumna < 0 || nuevaColumna >= cuadriculaIA.getNumColumnas() || cuadriculaIA.getCuadricula()[nuevaFila][nuevaColumna] != 'A');

            cuadriculaIA.getCuadricula()[filaActual][columnaActual] = 'A';
            cuadriculaIA.getCuadricula()[nuevaFila][nuevaColumna] = 'B';
            filaActual = nuevaFila;
            columnaActual = nuevaColumna;
        }


    }

    public boolean disparar(int fila, int columna){
        fila--;
        columna--;
        if (fila < 0 || fila >= cuadriculaIA.getNumFilas() || columna < 0 || columna >= cuadriculaIA.getNumColumnas()){
            System.out.println("Posición fuera de la cuadricula");
            return false;
        } else if (cuadriculaIA.getCuadricula()[fila][columna] == 'B') {
            cuadriculaIA.getCuadricula()[fila][columna] = 'X';
            System.out.println("¡Barco hundido!");
            return true;
        } else {
            System.out.println("Disparo fallido");
            return false;
        }
    }


}