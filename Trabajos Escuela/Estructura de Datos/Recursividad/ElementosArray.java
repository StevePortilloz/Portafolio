package Recursividad;

import java.util.Scanner;

public class ElementosArray {

	public static void main(String[] args) {
		
		Scanner c = new Scanner(System.in);
		int[] array = {3,2,5,6,8,9,0};
		
		System.out.println("elemento a encontrar: ");
		int element = c.nextInt();
		
		System.out.println("El elemento esta en la posicion: "+ (Search(array, element, 0) + 1));
	
	}//FIN MAIN
	
	public static int Search(int[] a, int elemento, int i) {
		
		if(a[i] != elemento) {
			return Search(a, elemento, ++i);
		}
			return i;
	}

}
