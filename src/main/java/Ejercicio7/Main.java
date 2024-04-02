package Ejercicio7;

import java.util.HashMap;

public class Main {
    public static HashMap<String, HashMap<String, Barco>> hashTipoBarco = new HashMap<String, HashMap<String, Barco>>();
    public static HashMap<String, Barco> hashNumeroBarco = new HashMap<>();
    public static HashMap<String, Barco> hashNombreBarco = new HashMap<>();

    public static void cargarBarco(int numero, String nombre, String tipo, int nivel){
        Barco barco = new Barco(numero, nivel, nombre, tipo);

        if (!hashTipoBarco.containsKey(tipo)){
            hashTipoBarco.put(tipo, new HashMap<>());
        }
        hashTipoBarco.get(tipo).put(nombre, barco);
        hashNumeroBarco.put(String.valueOf(numero), barco);
        hashNombreBarco.put(nombre, barco);
    }

    public static void main(String[] args) {
        cargarBarco(1, "Barco1", "Tipo1", 1);
        cargarBarco(2, "Barco2", "Tipo2", 2);
        cargarBarco(3, "Barco3", "Tipo1", 3);

    }
}
