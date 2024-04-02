package Ejercicio1.EstrategiaPosicionamiento;

import Ejercicio1.Barco.Barco;
import Ejercicio1.Barco.Orientacion;
import Ejercicio1.Cuadricula.CuadriculaIA;

public class EstrategiaPosicionamientoConsecutivo implements EstrategiaPosicionamiento{
    @Override
    public void posicionarBarco(CuadriculaIA cuadricula, Barco barco) {
        int filaInicial = barco.getFilaActual();
        int columnaInicial = barco.getColumnaActual();
        int tamano = barco.getTamano();

        if (barco.getOrientacion() == Orientacion.HORIZONTAL){ //Verificamos si el barco cabe en la posicion inicial.
            if (columnaInicial + tamano > cuadricula.getNumColumnas()){
                filaInicial++;  //Si no cabe, movemos el barco a la siguiente fila.
                columnaInicial = 0;
            }

            for(int i = 0; i < tamano; i++) {
                cuadricula.getCuadricula()[filaInicial][columnaInicial + i] = 'B';
            }
        } else { //Orientacion vertical
            if (filaInicial + tamano > cuadricula.getNumFilas()){
                columnaInicial++;
                filaInicial = 0;
            }

            for(int i = 0; i < tamano; i++) {
                cuadricula.getCuadricula()[filaInicial + i][columnaInicial] = 'B';
            }
        }



    }
}
