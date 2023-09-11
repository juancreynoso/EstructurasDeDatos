package main;
import lista.ListaArreglo;

public class Main{
    public static void main(String[] args){
        ListaArreglo<Integer> listaDeEnteros = new ListaArreglo<>(10);
        for(int i = 1; i <= 10; i++){
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

        ListaArreglo <Integer> listaDeEnteros2 = new ListaArreglo<>(10);
        listaDeEnteros2 = (ListaArreglo) listaDeEnteros.subLista(1, 4);
        System.out.println(listaDeEnteros2.toString());
    }
}