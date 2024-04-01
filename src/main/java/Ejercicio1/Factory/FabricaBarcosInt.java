package Ejercicio1.Factory;
import Ejercicio1.Barco.TiposDeBarcos.*;
import Ejercicio1.Barco.Barco;

public interface FabricaBarcosInt {
    Barco crearBattleship();
    Barco crearFrigate();
    Barco crearCanoe();
}
