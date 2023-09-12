package main;

import cola.ColaArregloFijo;
import cola.ColaEnlazada;

public class MainCola {
    public static void main(String[] args) {
        ColaEnlazada<Integer> lista = new ColaEnlazada<>(0);
        for (int i = 0; i < 10; i++) {
            lista.encolar(i); 
        }
        System.out.println(lista);
        // lista.desencolar();
        // lista.desencolar();
        // lista.desencolar();
        // lista.desencolar();
        // lista.desencolar();
        // System.out.println(lista);
    }
}
