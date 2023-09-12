package cola;
import lista.Node;

public class ColaEnlazada<T> implements Cola<T> {
    private Node<T> head;
    private int elementos;

    public ColaEnlazada() {
        elementos = 0;
        head = null;
    }

    public ColaEnlazada(int capacidad) {
        elementos = capacidad;
        head = null;
    }

    public boolean esVacia() {
        return head == null;
    }

    public boolean encolar(T elem) {
        Node<T> puntero = new Node<T>(elem);
        puntero = head;
        while (puntero.getNext() != null) {
            puntero = puntero.getNext();
        }
        puntero.setNext(puntero);
        elementos ++;
        return true;
    }

    public T desencolar() {
        if (this.esVacia()) {
			throw new IllegalStateException("La lista está vacía.");
		} else {
            T elem = (T) head.getInfo();
            head = head.getNext();
            return elem;
        }
    }

    public T primero() {
        if (this.esVacia()) {
            throw new IllegalStateException("La lista está vacía.");
        }
        return (T) head.getInfo();
    }

    public void vaciar() {
        head = null;
    }

    public int elementos() {
        return elementos;
    }

    public boolean repOK() {
        return true;
    }

    public String toString() {
        String result = "[";
        Node<T> punt = new Node<T>();
        punt = head;
        while (punt != null) {
            result = result + punt.getInfo();
            if (punt.getNext() != null) {
                result = result + ", ";
            }
        }
        return result + "]";
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ColaEnlazada)) {
            return false; 
        }
        ColaEnlazada otraCola = (ColaEnlazada) other;
        int cant = 0;
        if (otraCola.elementos() == this.elementos) {
            Node<T> punt = new Node<>();
            Node<T> punt2 = new Node<>();
            punt.setNext(this.head);
            punt2.setNext(otraCola.head);
            while (punt != null) {
                while (punt2 != null) {
                    if (punt.getInfo() == punt2.getInfo()) {
                        cant++;
                    }
                }
            }  
            return this.elementos == cant;
        }
        return false;
        
        
    }

    // public T obtener(int indice) {
    //     if ((indice < 0) || (indice > this.elementos()))
    //         throw new IndexOutOfBoundsException("el indice esta fuera del rango válido");
    //     Node<T> aux = new Node<T>();
    //     aux = head;
    //     for (int i = 0; i < indice; i++) {
    //         aux = aux.getNext();
    //     }
    //     return aux.getInfo();
    // }
}
