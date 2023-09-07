package lista;
import java.util.Collection;

/**
 * Implementación basada en arreglos de tamaño fijo de la interfaz {@code Lista}.
 * @see colecciones.lista.Lista
 */
public class ListaArreglo<T> implements Lista<T> {

    /**
     * Capacidad máxima por defecto ({@value #CAPACIDAD_POR_DEFECTO})
     */
    public static final int CAPACIDAD_POR_DEFECTO = 30;

    /**
    Declaración de la lista en formato de arreglo
     */
    private T[] items;

    /**
    Entero que cuenta la cantidad de elementos que contiene la lista
     */
    private int elementos;

    /**
     * Constructor de la clase ListaArreglo.
     * Crea un arreglo de objetos de tipo T de tamaño CAPACIDAD_POR_DEFECTO,
     * y se inicializa elementos en 0;
     */
    @SuppressWarnings("unchecked")
    public ListaArreglo() {
        items = (T[]) new Object[CAPACIDAD_POR_DEFECTO];
        elementos = 0;
    }

    /**
     * Construye una nueva lista vacía con una capacidad determinada mayor a 0.
     * @param la capacidad de la cola.
     * @throws IllegalArgumentException si {@code capacidad} es menor o igual a 0.
     */
    public ListaArreglo(int capacidad) {
        if (capacidad <= 0)
            throw new IllegalArgumentException("la capacidad debe ser un numero positivo (" + capacidad + ")");
        items = (T[]) new Object[capacidad];
    }

    /**
     * Agrega un elemento al final de la lista.
     * @param elem el elemento a agregar
     * @return {@code true} sii el elemento pudo ser agregado
     */
    public boolean agregar(T elem) {
        if (elementos >= CAPACIDAD_POR_DEFECTO)
            throw new IllegalArgumentException("la lista está llena");
        items[elementos] = elem;
        elementos++;
        return true;
    }

    /**
     * Agrega todos los elementos de otra lista, al final de esta lista.
     * @param otraLista lista conteniendo todos los elementos a agregar al final de esta lista
     * @return {@code true} sii todos los elementos en {@code otraLista} fueron agregados
     * @throws java.lang.IndexOutOfBoundsException si {@code indice} &lt; {@code 0} || {@code indice} &gt; {@code #elementos()}
     */
    public boolean agregarTodos(Lista<T> otraLista) {
        if (otraLista == null)
            throw new IllegalArgumentException("otraLista es null");
        for (int i = 0; i <= this.elementos(); i++) {
            this.agregar(otraLista.obtener(i));
        }
        return true;
    }

    /**
     * Agrega un elemento en una posicion particular de la lista.
     * @param elem el elemento a agregar
     * @param indice el indice donde se agrega el elemento
     * @return {@code true} sii el elemento pudo ser agregado
     * @throws IndexOutOfBoundsException si {@code indice} &lt; {@code 0} || {@code indice} &gt; {@code #elementos()}
     */
    public boolean insertar(T elem, int indice) {
        if (indice < 0 || indice > this.elementos)
            throw new IndexOutOfBoundsException("el indice debe ser mayor a 0");
        for (int i = indice; i <= this.elementos(); i++) {
            this.items[i+1] = this.items[i];
        }
        elementos++;
        this.agregar(elem);
        return true;
    }

    /**
     * Elimina un elemento de esta lista en una posición particular.
     * @param indice el indice el elemento a eliminar
     * @return el elemento eliminado
     * @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &gt; {@code #elementos()})
     * @see #elementos()
     */
    public T eliminar(int indice) {
        if ((indice < 0) || (indice > this.elementos))
            throw new IndexOutOfBoundsException("indice fuera de rango");
        if (indice > this.elementos)
            for (int i = indice; i < this.elementos-1; i++) {
                this.items[i] = this.obtener(i+1);
            }
            return this.obtener(indice);
    }

    /**
     * Obtiene un elemento de esta lista en una posición particular.
     * @param indice el indice el elemento a obtener
     * @return el elemento en la posición {@code indice}
     * @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
     * @see #elementos()
     */
    public T obtener(int indice) {
        if ((indice < 0) || (indice > this.elementos))
            throw new IndexOutOfBoundsException("el indice esta fuera del rango válido");
        return this.items[indice];
    }

    /**
     * Retorna la cantidad de elementos agregados a la lista.
     * @return cantidad de elementos en la lista
     */
    public int elementos() {
        return this.elementos;
    }

    /**
     * Remueve todos los elementos en la lista.
     */
    public void vaciar() {
        this.elementos = 0;
    }

    /**
     * Permite evaluar si la lista no tiene elementos.
     * Este método es equivalente a:
     * <pre>lista.elementos() == 0</pre>
     * @return {@code true} sii la pila no tiene elementos
     */
    public boolean esVacia() {
        return this.elementos == 0;
    }

    /**
     * Evalúa igualdad entre esta y otra lista. La igualdad considera que el tamaño de ambas listas es el mismo, y que los elementos de ambas listas son iguales considerando el orden de los mismos de acuerdo a la implementación de cada lista.
     * La igualdad entre elementos se realiza considerando si ambos son {@code null} o, en caso contrario, mediante el método {@code equals(Object)}.
     * @return {@code true} sii ambas listas tienen los mismos elementos.
     */
    @Override
    public boolean equals(Object otro) {
        if (!(otro instanceof ListaArreglo))
            return false;
        ListaArreglo otroLista = (ListaArreglo) otro;
        int cant = 0;
        if (this.elementos == otroLista.elementos)
            for (int i=0; i<=this.elementos; i++) {
                if (this.obtener(i) == otroLista.obtener(i))
                cant++;
            }
        return cant == this.elementos;
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
        for (int i=0; i<=elementos; i++) {
            //result.append(obtener(i).toString()).append(", ");
            result = result + obtener(i) + ", ";
        }
        result = result + "]";
        return result;
    }

    /**
     * Evalua si esta lista contiene un elemento particular, utilizando el método {@code equals(Object)}.
     * @param elem el elemento a buscar
     * @return {@code true} sii, existe un elemento {@code e} en la lista, tal que {@code e == null && elem == null || e.equals(elem)}
     */
    public boolean contiene(T elem) {
        for (int i=0; i<=elementos; i++) {
            if (elem.equals(this.obtener(i)))
                return true;
        }
        return false;
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
        if ((desdeInd < 0) || (hastaInd > elementos))
            throw new IndexOutOfBoundsException("los indices de inicio y fin están fuera de rango");
        ListaArreglo result = new ListaArreglo();
        for (int i=desdeInd; i<=hastaInd; i++) {
            result.agregar(this.obtener(i));
        }
        return result;
    }

    /**
     * Invariante de clase.
     * @return {@code true} sii la lista satisface su invariante de clase
     */
    public boolean repOK() {
        return this instanceof ListaArreglo;
    }

}