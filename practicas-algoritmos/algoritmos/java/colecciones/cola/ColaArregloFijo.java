package cola;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

/**
* Implementación basada en arreglos de tamaño fijo de la interfaz {@code Cola}.
* @see colecciones.cola.Cola
*/
public class ColaArregloFijo<T> implements Cola<T> {

	/**
	* Capacidad máxima por defecto ({@value #CAPACIDAD_POR_DEFECTO})
	*/
	public static final int CAPACIDAD_POR_DEFECTO = 20;
	private Object[] arreglo;
	private int elementos = 0;

	/**
	* Construye una nueva cola vacía con una capacidad máxima de {@value #CAPACIDAD_POR_DEFECTO}.
	*/
	public ColaArregloFijo() {
		this(CAPACIDAD_POR_DEFECTO);
	}

	/**
	* Construye una nueva cola vacía con una capacidad determinada mayor a 0.
	* @param capacidad la capacidad de la cola
	* @throws IllegalArgumentException si {@code capacidad} es menor o igual a 0 
	*/
	public ColaArregloFijo(int capacidad) {
		if (capacidad <= 0)
			throw new IllegalArgumentException("la capacidad debe ser un numero positivo (" + capacidad + ")");
		arreglo = new Object[capacidad];
	}

	/**
	* Construye una cola a partir de elementos en una colección.
	* Los elementos en la colección se encolan de izquierda a derecha.
	* La capacidad de la cola va a ser suficiente para por lo menos contener todos los elementos de la colección.
	* @param elems los elementos a agregar a la cola
	*/
	public ColaArregloFijo(Collection<T> elems) {
		if (elems == null)
			throw new IllegalArgumentException("elems es null");
		arreglo = new Object[Math.max(elems.size(), CAPACIDAD_POR_DEFECTO)];
		for (T e : elems) {
			encolar(e);	
		}
	}

	@Override
	public boolean esVacia() {
		return elementos == 0;	
	}

	@Override
	public int elementos() {
		return elementos;
	}

	@Override
	public boolean encolar(T elem) {
		if (elementos >= CAPACIDAD_POR_DEFECTO) {
			return false;
		} else {
			this.arreglo[elementos] = elem;
			elementos ++;
			return true;
		}
	}

	@Override
	public T desencolar() {
		if (this.esVacia()) {
			throw new IllegalStateException("La lista está vacía.");
		}
		T elem = (T) this.arreglo[0];
		for (int i = 0; i < elementos-1; i++) {
			this.arreglo[i] = this.arreglo[i+1];
		}
		elementos --;
		return elem;
	}

	@Override
	public T primero() {
		if (this.esVacia()) {
			throw new IllegalStateException("La lista está vacía.");
		} else {
			return (T) this.arreglo[0];
		}
	}

	@Override
	public void vaciar() {
		this.elementos = 0;	
	}

	@Override
	public boolean repOK() {
		return elementos <= CAPACIDAD_POR_DEFECTO;

	}

	@Override
	public String toString() {
		String result = "[";
		for (int i = 0; i < this.elementos; i++) {
			result = result + this.arreglo[i];
			if (i != elementos-1) {
				result = result + ", ";
			}
		}
		return result + "]";
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof ColaArregloFijo))
            return false;
        ColaArregloFijo otraCola = (ColaArregloFijo) other;
        int cant = 0;
        if (this.elementos == otraCola.elementos)
            for (int i=0; i<=this.elementos; i++) {
                if (this.arreglo[i] == otraCola.arreglo[i])
                    cant++;
            }
        return cant == this.elementos;	
	}

	/**
	* Permite obtener un elemento del arreglo en un indice determinado realizando el casteo necesario.
	* @param index el indice del elemento a obtener
	*/
	@SuppressWarnings("unchecked")
   	public T elemento(int index) {
        	return (T) arreglo[index];
    	}

}
