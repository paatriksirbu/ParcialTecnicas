package Ejercicio1.Barco.TiposDeBarcos;

import Ejercicio1.Barco.Barco;
import Ejercicio1.Barco.Clima;
import Ejercicio1.Cuadricula.CuadriculaIA;
import Ejercicio1.EstrategiaPosicionamiento.EstrategiaPosicionamiento;

public class Frigate extends Barco {

    public Frigate(int tamano, CuadriculaIA cuadriculaIA, int filaInicial, int columnaInicial, Clima clima, EstrategiaPosicionamiento estrategia) {
        super(3, cuadriculaIA, filaInicial, columnaInicial, clima, estrategia);
    }

    @Override
    public boolean disparar(int fila, int columna){
        return super.disparar(fila, columna);
    }

}
