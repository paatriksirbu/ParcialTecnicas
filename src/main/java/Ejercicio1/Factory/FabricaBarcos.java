package Ejercicio1.Factory;
import Ejercicio1.Barco.TiposDeBarcos.*;
import Ejercicio1.Barco.Barco;
import Ejercicio1.Barco.Clima;
import Ejercicio1.Cuadricula.CuadriculaIA;
import Ejercicio1.EstrategiaPosicionamiento.EstrategiaPosicionamiento;

public class FabricaBarcos implements FabricaBarcosInt {

    //Definimos las variables que se llamaran mas adelante en el constructor
    private CuadriculaIA cuadriculaIA;
    private int filaInicial;
    private int columnaInicial;
    private Clima clima;
    private EstrategiaPosicionamiento estrategia;

    public FabricaBarcos(CuadriculaIA cuadriculaIA, int filaInicial, int columnaInicial, Clima clima, EstrategiaPosicionamiento estrategia) {
        this.cuadriculaIA = cuadriculaIA;
        this.filaInicial = filaInicial;
        this.columnaInicial = columnaInicial;
        this.clima = clima;
        this.estrategia = estrategia;
    }
    //Metodos que crean los barcos de cada tipo para ser usados en el juego
    @Override
    public Barco crearBattleship() {
        return new Battleship(5, cuadriculaIA, filaInicial, columnaInicial, clima, estrategia);
    }

    @Override
    public Barco crearFrigate() {
        return new Frigate(3, cuadriculaIA, filaInicial, columnaInicial, clima, estrategia);
    }

    @Override
    public Barco crearCanoe() {
        return new Canoe(1, cuadriculaIA, filaInicial, columnaInicial, clima, estrategia);
    }
}
