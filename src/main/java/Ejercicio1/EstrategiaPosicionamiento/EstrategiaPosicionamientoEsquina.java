package Ejercicio1.EstrategiaPosicionamiento;

import Ejercicio1.Barco.Barco;
import Ejercicio1.Cuadricula.CuadriculaIA;

public class EstrategiaPosicionamientoEsquina implements EstrategiaPosicionamiento{

    @Override
    public void posicionarBarco(CuadriculaIA cuadricula, Barco barco){
        int fila = 0;
        int columna = 0;
        cuadricula.depositarBarco(fila, columna, barco);
    }
}