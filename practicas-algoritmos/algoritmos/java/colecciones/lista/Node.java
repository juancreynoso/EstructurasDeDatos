package lista;

public class Node<T> {
    private T info;
    private Node<T> next;
    
    //Constructors
    public Node() {
        next = null;
    }

    public Node(T info) {
        this.info = info;
        this.next = null;
    }

    //Getters
    /**
     * Obtiene el valor del nodo actual
     * @return valor del nodo actual.
     */
    public T getInfo() {
        return this.info;
    }

    /**
     * Obtiene el siguiente nodo
     * @return siguiente nodo.
     */
    public Node<T> getNext() {
        return this.next;
    }

    //Setters

    /**
     * Asigna el valor del parametro al nodo
     * @param info Valor que se le asigna al nodo
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * Modifica el siguiente nodo
     * @param next 
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
