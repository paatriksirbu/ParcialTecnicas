package Ejercicio1.EstrategiaPosicionamiento;
import Ejercicio1.Barco.Barco;
import Ejercicio1.Cuadricula.CuadriculaIA;

public class EstrategiaPosicionamientoCentro implements EstrategiaPosicionamiento{

    @Override
    public void posicionarBarco(CuadriculaIA cuadricula, Barco barco){
        int fila = (int) (Math.random() * cuadricula.getNumFilas()/2);
        int columna = (int) (Math.random() * cuadricula.getNumColumnas()/2);
        cuadricula.depositarBarco(fila, columna, barco);
    }
}