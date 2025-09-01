package dinamicas;

import java.util.Scanner;

public class AplArbol {

	public static void main(String[] args) {

		Arbol<MyInteger> arbol =new Arbol<MyInteger>();
		MyInteger numero;

//		arbol.Insertar(new MyInteger(15, 2));
//		arbol.Insertar(new MyInteger(9, 2));
//		arbol.Insertar(new MyInteger(20, 2));
//		arbol.Insertar(new MyInteger(5, 2));
//		arbol.Insertar(new MyInteger(10, 2));
//		arbol.Insertar(new MyInteger(25, 2));
//		arbol.Insertar(new MyInteger(22, 2));
//		arbol.Insertar(new MyInteger(30, 2));
//		arbol.Insertar(new MyInteger(29, 2));
//		arbol.Insertar(new MyInteger(32, 2));
//		arbol.Insertar(new MyInteger(31, 2));
		
		arbol.Insertar(new MyInteger(15, 2));
		arbol.Insertar(new MyInteger(7, 2));
		arbol.Insertar(new MyInteger(10, 2));
		arbol.Insertar(new MyInteger(13, 2));
		arbol.Insertar(new MyInteger(5, 2));
		arbol.Insertar(new MyInteger(9, 2));
		arbol.Insertar(new MyInteger(8, 2));
		arbol.Insertar(new MyInteger(6, 2));
		arbol.Insertar(new MyInteger(4, 2));
		arbol.Insertar(new MyInteger(3, 2));
		arbol.Insertar(new MyInteger(1, 2));
		arbol.Insertar(new MyInteger(20, 2));
		arbol.Insertar(new MyInteger(30, 2));
		arbol.Insertar(new MyInteger(25, 2));
		arbol.Insertar(new MyInteger(18, 2));
		arbol.Insertar(new MyInteger(16, 2));
		arbol.Insertar(new MyInteger(19, 2));
		arbol.Insertar(new MyInteger(35, 2));
		arbol.Insertar(new MyInteger(22, 2));
		arbol.Insertar(new MyInteger(26, 2));
		arbol.Insertar(new MyInteger(33, 2));
		arbol.Insertar(new MyInteger(37, 2));

		System.out.println("\n_____Mostrar InOrden_____");
		arbol.InOrden(arbol.getRaiz());


		System.out.println("\n_____Eliminar Nodo.ID: 1_____");
		arbol.Delete(new MyInteger(1, 2));
		System.out.println("\nMostrar Arbol Actualizado");
		arbol.InOrden(arbol.getRaiz());
		
//		System.out.println("\n_____Eliminar Nodo.ID: 4_____");
//		arbol.Delete(new MyInteger(4, 2));
//		System.out.println("\nMostrar Arbol Actualizado");
//		arbol.InOrden(arbol.getRaiz());
//		
//		System.out.println("\n_____Eliminar Nodo.ID: 30_____");
//		arbol.Delete(new MyInteger(30, 2));
//		System.out.println("\nMostrar Arbol Actualizado");
//		arbol.InOrden(arbol.getRaiz());
//		
//		System.out.println("\n_____Eliminar Raiz.ID: 15_____");
//		arbol.Delete(new MyInteger(15, 2));
//		System.out.println("\nMostrar Arbol Actualizado");
//		arbol.InOrden(arbol.getRaiz());
//		
//		System.out.println("\nMostrar Preorden (Nueva raiz al inicio)");
//		arbol.PreOrden(arbol.getRaiz());
		
		
		System.out.println("\n_____Nivel del Nodo.ID: 5_____");
		//NIVEL DE LA RAIZ = 1
		System.out.println("Nivel: "+ arbol.NivelNodo(new MyInteger(5, 2)));
		
		System.out.println("\n_____Grado del Nodo.ID: 5_____");
		//NIVEL DE LA RAIZ = 1
		System.out.println("Es de grado: " + arbol.GradoNodo(new MyInteger(5, 2)));

		
		
		
		
		

		//		System.out.println("Cuenta "+cuenta);
		//		System.out.println("Recorrido preorden");
		//		preorden(Raiz);
		//		System.out.println("Recorrido postorden");
		//		postorden(Raiz);
		//		//System.out.println("DATO A BORRAR ");
		//		//String Dato=Leer.dato();
		//		//Raiz=BorraABB(Raiz,Dato);
		//
		//		System.out.println("Recorrido inorden 2");
		//		inorden(Raiz); 
		//		System.out.println("Recorrido postorden 2");
		//		postorden(Raiz);
		//		suma(Raiz);
		//		System.out.println("total  "+total);

	}

}
