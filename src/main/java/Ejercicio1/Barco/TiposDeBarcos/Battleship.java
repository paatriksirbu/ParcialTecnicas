package Ejercicio1.Barco.TiposDeBarcos;

import Ejercicio1.Barco.Barco;
import Ejercicio1.Barco.Clima;
import Ejercicio1.Cuadricula.CuadriculaIA;
import Ejercicio1.EstrategiaPosicionamiento.EstrategiaPosicionamiento;

public class Battleship extends Barco {

    private boolean [] seccionesAisladas;

    public Battleship(int tamano, CuadriculaIA cuadriculaIA, int filaInicial, int columnaInicial, Clima clima, EstrategiaPosicionamiento estrategia) {
        super(5, cuadriculaIA, filaInicial, columnaInicial, clima, estrategia);
        this.seccionesAisladas = new boolean[5];

        for (int i = 0; i < seccionesAisladas.length; i++) {
            seccionesAisladas[i] = false;
        }
    }

    public void tocarSeccionAislada(int seccion){
        if (seccion >= 0 && seccion < seccionesAisladas.length){
            seccionesAisladas[seccion] = true;
        }
    }

    @Override
    public boolean disparar(int fila, int columna){
        if(super.disparar(fila, columna)){

            int seccion = -1;   //Comprobar seccion a la que se ha disparado
            tocarSeccionAislada(seccion);

            for (boolean seccionAislada : seccionesAisladas) {
                if (!seccionAislada){
                    return false;
                }
            }
            return true;
        }
        return false;
    }


}
