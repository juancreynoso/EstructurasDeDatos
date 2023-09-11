package lista;

public class ListaEnlazada<T> implements Lista<T> {
    private int cant;
    private Node<T> head;

    public ListaEnlazada() {
        head = null;
        cant = 0;
    }

    public ListaEnlazada(int cant) {
        this.head = null;
        this.cant = cant;
    }

    /**
     * Agrega un elemento al final de la lista.
     * @param elem el elemento a agregar
     * @return {@code true} sii el elemento pudo ser agregado
     */
    public boolean agregar(T elem){
        if (head == null) {
            Node<T> aux = new Node<T>(elem);
            head = aux;
            cant++;
            return true;
        } else {
            Node<T> aux = new Node<T>();
            aux = head;
            while (aux.getNext() != null) {
               aux = aux.getNext();
            }
            Node<T> aux2 = new Node<T>(elem);
            aux2.setNext(null);
            aux.setNext(aux2);
            cant++;
            return true;
        }        
    }

    /**
     * Agrega todos los elementos de otra lista, al final de esta lista.
     * @param otraLista lista conteniendo todos los elementos a agregar al final de esta lista
     * @return {@code true} sii todos los elementos en {@code otraLista} fueron agregados
     */
    public boolean agregarTodos(Lista<T> otraLista) {
        if (otraLista == null) {
            throw new IllegalArgumentException("otraLista es null");
        } else {
            for (int i = 0; i <= otraLista.elementos(); i++) {
                this.agregar(otraLista.obtener(i));
            }
            return true;
        }  

    }

    /**
     * Agrega un elemento en una posicion particular de la lista.
     * @param elem el elemento a agregar
     * @param indice el indice donde se agrega el elemento
     * @return {@code true} sii el elemento pudo ser agregado
     * @throws IndexOutOfBoundsException si {@code indice} &lt; {@code 0}
     */
    public boolean insertar(T elem, int indice) {
        if (indice > cant || indice < 0) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }

        Node<T> aux = new Node<T>();
        Node<T> aux2 = new Node<T>(elem);
        aux = head;
        aux2 = head;
        for (int i = 0; i < indice-1; i++) {
            aux.setNext(aux.getNext());
        }
        aux2 = aux.getNext();
        aux.setNext(aux2);
        return true;
    }

    /**
     * Elimina un elemento de esta lista en una posición particular.
     * @param indice el indice el elemento a eliminar
     * @return el elemento eliminado
     * @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
     * @see #elementos()
     */
    public T eliminar(int indice) {
        if ((indice < 0) || (indice > this.elementos()))
            throw new IndexOutOfBoundsException("el indice esta fuera del rango válido");
        Node<T> aux = new Node<T>();
        aux = head;
        for (int i = 0; i < indice; i++) {
            aux = aux.getNext();
        }
        aux.setNext(null);
        return aux.getInfo();
    }

    /**
     * Obtiene un elemento de esta lista en una posición particular.
     * @param indice el indice el elemento a obtener
     * @return el elemento en la posición {@code indice}
     * @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
     * @see #elementos()
     */
    public T obtener(int indice) {
        if ((indice < 0) || (indice > this.elementos()))
            throw new IndexOutOfBoundsException("el indice esta fuera del rango válido");
        Node<T> aux = new Node<T>();
        aux = head;
        for (int i = 0; i < indice; i++) {
            aux = aux.getNext();
        }
        return aux.getInfo();
    }

    /**
     * Retorna la porción de esta lista entre los índice especificados {@code desdeInd}, inclusivo, y {@code hastaInd}, exclusivo, en una nueva lista.
     * Si {@code fromInd} es igual a {@code hastaInd} se retorna un a lista vacía.
     * @param desdeInd el índice inferior, inclusivo
     * @param hastaInd el índice superior, exclusivo
     * @return una nueva lista formada con los elementos entre {@code desdeInd} hasta {@code hastaInd - 1} de esta lista
     * @throws IndexOutOfBoundsException si ({@code fromInd} &lt; {@code 0} || {@code hastaInd} &gt; {@code #elementos()} || {@code desdeInd} &gt; {@code hastaInd})
     * @see #elementos()
     */
    public Lista<T> subLista(int desdeInd, int hastaInd) {
        ListaEnlazada<T> result = new ListaEnlazada<T>();
        for (int i = desdeInd; i < hastaInd; i++) {
            result.agregar(this.obtener(i));
        }
        return result;
        
    }

    /**
     * Evalua si esta lista contiene un elemento particular, utilizando el método {@code equals(Object)}.
     * @param elem el elemento a buscar
     * @return {@code true} sii, existe un elemento {@code e} en la lista, tal que {@code e == null && elem == null || e.equals(elem)}
     */
    public boolean contiene(T elem) {
        Node<T> aux = new Node<T>();
        aux = head;
        while (aux.getNext() != null) {
            if (elem.equals(aux.getInfo()))
                return true;
            aux = aux.getNext();
        }
        return false;
    }

    /**
     * Remueve todos los elementos en la lista.
     */
    public void vaciar() {
        head = null;
    }

    /**
     * Retorna la cantidad de elementos agregados a la lista.
     * @return cantidad de elementos en la lista
     */
    public int elementos() {
        return cant;
    }

    /**
     * Permite evaluar si la lista no tiene elementos.
     * Este método es equivalente a:
     * <pre>lista.elementos() == 0</pre>
     * @return {@code true} sii la pila no tiene elementos
     */
    public boolean esVacia() {
        return cant == 0;
    }

    /**
     * Invariante de clase.
     * @return {@code true} sii la lista satisface su invariante de clase
     */
    public boolean repOK() {
        return true;
    }

    /**
     * Retorna una representación como {@code String} de esta lista. La representación como {@code String} consiste de los elementos en esta lista, en el orden correspondiente a la implementación de la misma, encerrados entre corchetes ("[]").
     * Elementos adyacentes están separados mediante los caractéres ", " (coma y espacio). Los elementos son convertidos mediante {@code String.valueOf(Object)}.
     * @return una representación como {@code String} de esta lista
     */
    @Override
    public String toString() {
        String result;
        result = "[";
        Node<T> aux = new Node<T>(head.getInfo());
        aux = head;
        while (aux != null) {
            result = result + String.valueOf(aux.getInfo());
            if (!(aux.getNext() == null))
                result = result + ", ";
            aux = aux.getNext();
        }
        return result + "]";
    }

    /**
     * Evalúa igualdad entre esta y otra lista. La igualdad considera que el tamaño de ambas listas es el mismo, y que los elementos de ambas listas son iguales considerando el orden de los mismos de acuerdo a la implementación de cada lista.
     * La igualdad entre elementos se realiza considerando si ambos son {@code null} o, en caso contrario, mediante el método {@code equals(Object)}.
     * @return {@code true} sii ambas listas tienen los mismos elementos.
     */
    @Override
    public boolean equals(Object otro) {
        if (!(otro instanceof ListaEnlazada))
            return false;
        ListaEnlazada<T> otroLista = (ListaEnlazada) otro;
        int cant = 0;
        if (this.elementos() == otroLista.elementos()) {
            Node<T> aux = new Node<T>();
            int i = 0;
            while (aux.getNext() != null) {
                if (this.obtener(i) == otroLista.obtener(i))
                    cant++;
                aux = aux.getNext();
                i++;
            }
        }
            
        return cant == this.cant;
    }


}
