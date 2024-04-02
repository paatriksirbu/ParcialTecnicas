package Ejercicio7;
import java.util.*;
public class Barco {
    private int numero, nivel;
    private String nombre, tipo;

    public Barco(int numero, int nivel, String nombre, String tipo){
        this.numero = numero;
        this.nivel = nivel;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
