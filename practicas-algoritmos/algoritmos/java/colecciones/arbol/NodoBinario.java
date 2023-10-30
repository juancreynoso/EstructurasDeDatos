package colecciones.arbol;

/**
 * Clase auxiliar para diccionarios implementados con nodos encadenados.
 */
public class NodoBinario<T>  {
    private T valor;
    private NodoBinario<T> izquierdo;
    private NodoBinario<T> derecho;
    private int altura;


    NodoBinario(T valor, NodoBinario<T> izquierdo, NodoBinario<T> derecho) {
       this.valor = valor;
       this.izquierdo = izquierdo;
       this.derecho = derecho;
       if (izquierdo.altura > derecho.altura) {
           this.altura = 1 + izquierdo.altura;
       } else {
           this.altura = 1 + derecho.altura;
       }
    }

    public NodoBinario(){
        this.valor = null;
        this.derecho = null;
        this.izquierdo = null;
        this.altura = 0;
    }

    public NodoBinario(T valor){
        this.valor = valor;
        this.derecho = null;
        this.izquierdo = null;
        this.altura = 0;
    }


    T getValor() {
        return valor;
    }

    void setValor(T nuevoValor) {
        valor = nuevoValor;
    }

    NodoBinario<T> getIzquierdo() {
        return izquierdo;
    }

    void setIzquierdo(NodoBinario<T> nuevoIzquierdo) {
        this.izquierdo = nuevoIzquierdo;
        if (izquierdo.altura > derecho.altura) {
            altura = 1 + izquierdo.altura;
        }
    }

    NodoBinario<T> getDerecho() {
        return derecho;
    }

    void setDerecho(NodoBinario<T> nuevoDerecho) {
        this.derecho = nuevoDerecho;
        if (derecho.altura > izquierdo.altura) {
            altura = 1 + derecho.altura;
        }
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }


}
