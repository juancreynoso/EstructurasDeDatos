package pila;

public class MainPila {
    public static void main(String[] args) {
        PilaArreglo<Integer> pilaEnteros = new PilaArreglo<>();
        PilaArreglo<Integer> pilaEnterosReversa = new PilaArreglo<>();

        pilaEnteros.apilar(1);
        pilaEnteros.apilar(4);
        pilaEnteros.apilar(23);
        pilaEnteros.apilar(7);

        System.out.println(pilaEnteros);

        int cant = pilaEnteros.elementos();
        for (int i = 0; i < cant; i++){
            pilaEnterosReversa.apilar(pilaEnteros.desapilar()); 
        }

        System.out.println(pilaEnterosReversa);
            

        // pilaEnteros.desapilar();
        // pilaEnteros.desapilar();
        // pilaEnteros.desapilar();
        // pilaEnteros.desapilar();

        // System.out.println(pilaEnteros);
        // System.out.println(pilaEnteros.esVacia()); 

        // pilaEnteros.apilar(1);
        // pilaEnteros.apilar(4);
        // pilaEnteros.apilar(23);
        // pilaEnteros.apilar(7);

        // System.out.println(pilaEnteros.esVacia()); 

        // pilaEnteros.empty();
        // System.out.println(pilaEnteros);



    }
}
