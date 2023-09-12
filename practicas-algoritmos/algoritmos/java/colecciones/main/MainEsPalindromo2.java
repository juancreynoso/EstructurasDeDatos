package main;
import cola.ColaEnlazada;
import lista.Node;

import java.util.Scanner;

public class MainEsPalindromo2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese la palabra: \n");
        String cadena = input.nextLine();

        ColaEnlazada<Character> palabra = new ColaEnlazada<Character>(cadena.length());
        //Node<Character> punt = new Node<>();
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            palabra.encolar(caracter);
        }

        int j = palabra.elementos()-1;
        boolean esPalindromo = true;
        for (int i = 0; i<j/2; i++) {
            if (!palabra.obtener(i).equals(palabra.obtener(j))) {
                esPalindromo = false;
                break;
            }
            j--;
        }
        if (esPalindromo) {
            System.out.println("Es palíndromo.");
        } else {
            System.out.println("No es palíndromo.");
        }
    }
}
