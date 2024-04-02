package Ejercicio1.EstrategiaPosicionamiento;

import Ejercicio1.Barco.Barco;
import Ejercicio1.Cuadricula.CuadriculaIA;

public class EstrategiaPosicionamientoConsecutivo implements EstrategiaPosicionamiento{
    @Override
    public void posicionarBarco(CuadriculaIA cuadricula, Barco barco) {
        int filaInicial = barco.getFilaActual();
        int columnaInicial = barco.getColumnaActual();
        int tamano = barco.getTamano();

        //Verificamos que el barco cabe en la fila desde su posicion inicial, si no cabe, lo movemos a la siguiente fila
        if (columnaInicial + tamano > cuadricula.getNumColumnas()) {
            filaInicial++;
            columnaInicial = 0;
        }


        for(int i = 0; i < tamano; i++) {
            cuadricula.getCuadricula()[filaInicial][columnaInicial + i] = 'B';
        }
    }
}
