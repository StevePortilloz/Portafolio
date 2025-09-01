package Recursividad;

import java.util.Scanner;

public class Yuliana {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		int dividendo, divisor;
        System.out.print("Introduce el dividendo: ");
        dividendo = entrada.nextInt();
        System.out.print("Introduce el divisor: ");
        divisor = entrada.nextInt();
        System.out.printf("%nLa división entre los dos números es: %d", divisionRecursiva(dividendo, divisor));
    }
     
    private static int divisionRecursiva(int dividendo, int divisor){
        if(divisor>dividendo){
            return 0;
        } else {
            return 1 + divisionRecursiva(dividendo-divisor, divisor);
        }
    }
 
}