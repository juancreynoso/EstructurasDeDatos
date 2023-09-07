package main;
import datos.Racional;

/**
 * La clase {@code Operaciones} representa las operaciones suma y resta con números racionales
**/

public class Main {
	public static void main(String[] args) {
		Racional num1 = new Racional(1, 3);
		Racional num2 = new Racional(2, 5);
		Racional num3;
		Racional num4;
		num3 = num2.suma(num1);
		num4 = num2.resta(num1);
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num1 + " + " + num2 + " = " + num3);
		System.out.println(num1 + " - " + num2 + " = " + num4);
		System.out.println(num1.equals(num2));

	}

}