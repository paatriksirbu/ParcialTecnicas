package Ejercicio1.Factory;
import Ejercicio1.Barco.TiposDeBarcos.*;
import Ejercicio1.Barco.Barco;

public class FabricaBarcos implements FabricaBarcosInt {

    @Override
    public Barco crearBattleship() {
        return new Battleship();
    }

    @Override
    public Barco crearFrigate() {
        return new Frigate();
    }

    @Override
    public Barco crearCanoe() {
        return new Canoe();
    }


}
