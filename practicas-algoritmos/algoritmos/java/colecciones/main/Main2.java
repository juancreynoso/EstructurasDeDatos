package main;
import lista.ListaEnlazada;

public class Main2 {
    public static void main(String[] args){
        ListaEnlazada<Integer> listaDeEnteros = new ListaEnlazada<Integer>();
        for(int i = 0; i < 10; i++){
            listaDeEnteros.agregar(i);
        }

        System.out.println(listaDeEnteros.toString());
        listaDeEnteros.eliminar(4);
        System.out.println(listaDeEnteros.obtener(4));
        System.out.println(listaDeEnteros.contiene(5));
        System.out.println(listaDeEnteros.contiene(4));
        System.out.println(listaDeEnteros.esVacia());
        System.out.println(listaDeEnteros.elementos());
        System.out.println(listaDeEnteros.repOK());
        System.out.println(listaDeEnteros.toString());

        ListaEnlazada <Integer> listaDeEnteros2 = new ListaEnlazada<>(10);
        listaDeEnteros2 = (ListaEnlazada<Integer>) listaDeEnteros.subLista(1, 4);
        System.out.println(listaDeEnteros2.toString());
    }

}
