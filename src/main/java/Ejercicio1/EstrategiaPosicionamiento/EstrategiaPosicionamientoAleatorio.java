package Ejercicio1.EstrategiaPosicionamiento;
import Ejercicio1.Cuadricula.CuadriculaIA;
import Ejercicio1.Barco.Barco;

public class EstrategiaPosicionamientoAleatorio implements EstrategiaPosicionamiento{

    @Override
    public void posicionarBarco(CuadriculaIA cuadricula, Barco barco){
        int fila = (int) (Math.random() * cuadricula.getNumFilas());
        int columna = (int) (Math.random() * cuadricula.getNumColumnas());
        cuadricula.depositarBarco(fila, columna, barco);
    }

}