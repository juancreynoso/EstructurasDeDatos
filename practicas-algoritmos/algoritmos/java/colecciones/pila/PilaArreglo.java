package pila;

import lista.ListaArreglo;

public class PilaArreglo<T> implements Pila<T> {

    public static final int CAPACIDAD_POR_DEFECTO = 20;
    private T[] pila;
    private int cant;
    
    public PilaArreglo() {
        pila = (T[]) new Object[CAPACIDAD_POR_DEFECTO];
        cant = 0;
    }

    
    public PilaArreglo(int capacidad) {
        if (capacidad <= 0)
            throw new IllegalArgumentException("la capacidad debe ser un numero positivo (" + capacidad + ")");
        pila = (T[]) new Object[capacidad];
        cant = 0;
    }

    public T tope(){
        if (esVacia())
            throw new IllegalAccessError("Pila vacía.");  
        return pila[cant-1];
    }

    public boolean esVacia() {
        return this.cant == 0;
    }

    public void empty() {
        this.cant = 0;
    }

    public boolean apilar(T elem) {
        if (this.cant < CAPACIDAD_POR_DEFECTO) {
            this.pila[cant] = elem;
            cant++;
            return true;
        } else {
            return false;
        }
    }        
    
    public int elementos() {
        return this.cant;
    }

    public T desapilar() {
        if (esVacia()) {
            throw new IllegalStateException("Pila vacia.");
        } 
        T elem = this.pila[cant-1];
        // for (int i = 0; i < this.cant-1; i++) {
        //     this.pila[i] = this.pila[i+1]; 
        // }
        cant --;
        return elem;
    }

    @Override
    public String toString() {
        String result;
        result = "[";
        for (int i=0; i<cant; i++) {
            result = result + String.valueOf(this.pila[i]);
            if (!(i == cant-1))
                result = result + ", ";
        }
        result = result + "]";
        return result;
    }

    @Override
    public boolean equals(Object otro) {
        if (!(otro instanceof ListaArreglo))
            return false;
        PilaArreglo otroLista = (PilaArreglo) otro;
        int cant = 0;
        if (this.cant == otroLista.cant)
            for (int i=0; i<=this.cant; i++) {
                if (this.pila[i] == otroLista.pila[i])
                    cant++;
            }
        return cant == this.cant;
    }
}
