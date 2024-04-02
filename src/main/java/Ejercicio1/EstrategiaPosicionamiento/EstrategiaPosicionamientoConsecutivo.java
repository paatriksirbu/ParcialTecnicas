package Ejercicio1.EstrategiaPosicionamiento;

import Ejercicio1.Barco.Barco;
import Ejercicio1.Cuadricula.CuadriculaIA;

public class EstrategiaPosicionamientoConsecutivo implements EstrategiaPosicionamiento{
    @Override
    public void posicionarBarco(CuadriculaIA cuadricula, Barco barco) {
        int filaInicial = barco.getFilaActual();
        int columnaInicial = barco.getColumnaActual();
        int tamano = barco.getTamano();

        for(int i = 0; i < tamano; i++) {
            cuadricula.getCuadricula()[filaInicial][columnaInicial + i] = 'B';
        }
    }
}
