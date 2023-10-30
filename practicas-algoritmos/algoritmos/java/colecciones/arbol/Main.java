package colecciones.arbol;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Comparator<Integer> comp = Comparator.naturalOrder();
        ABB<Integer> arbol = new ABB<>(comp);
        arbol.insertar(10);
        arbol.insertar(16);
        arbol.insertar(1);
        arbol.insertar(8);
        System.out.println(arbol.mayorValor());
    }
}