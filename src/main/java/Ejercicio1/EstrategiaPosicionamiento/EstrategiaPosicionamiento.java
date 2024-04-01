package Ejercicio1.EstrategiaPosicionamiento;

import Ejercicio1.Barco.Barco;
import Ejercicio1.Cuadricula.CuadriculaIA;

public interface EstrategiaPosicionamiento {
    void posicionarBarco(CuadriculaIA cuadricula, Barco barco);
}
