package main;
import cola.ColaArregloFijo;
import java.util.Scanner;

public class MainEsPalindromo {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        
        /* 
        //Una implementación
        ColaArregloFijo<Character> palabra = new ColaArregloFijo<>(30);
        char elem = '0';
        System.out.println("Digite una palabra, cuando finalice presione [1]. \n");
        while (elem != '1') {
            System.out.println("Ingrese caracter: \n");
            char carac = input.nextLine().charAt(0);
            palabra.encolar(carac);
            if (carac == '1') {
                break; // Sale del bucle cuando se ingrese '1'
            }
        }
        */

        //Otra implementación
        System.out.println("Ingrese la palabra: \n");
        String cadena = input.nextLine();
        ColaArregloFijo<Character> palabra = new ColaArregloFijo<>(cadena.length());
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            palabra.encolar(caracter);
        }

        int j = palabra.elementos()-1;
        boolean esPalindromo = true;
        for (int i = 0; i<j/2; i++) {
            if (!palabra.elemento(i).equals(palabra.elemento(j))) {
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
