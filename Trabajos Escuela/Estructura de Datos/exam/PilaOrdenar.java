package exam;

import java.util.Iterator;

//Objetivo: Hacer un metodo que ordene una pila o cola:

public class PilaOrdenar {

	public static void main(String[] args) {
		
		Pila<Integer> pila = new Pila<>(5);
		
		pila.Insertar(35);
		pila.Insertar(20);
		pila.Insertar(0);
		pila.Insertar(1);
		pila.Insertar(15);
		
		//1.-Metodo que ordena la pila
		
		System.out.println("Pila sin ordenar:");
		Imprime(pila);
		OrdenarPila(pila);
		System.out.println("\n\nPila Ordenada");
		Imprime(pila);
		
		//2.- Encontar y Remplazar un valor
		
		System.out.println("\n|-----Cambiar el valor 35 por 5-----|");
		CambiarValorP(pila, 35, 5);
		System.out.println("\n---Pila Actualizada---");
		Imprime(pila);
		System.out.println("\n---Pila Actualizada Ordenada---");
		OrdenarPila(pila);
		Imprime(pila);
		
	}
	private static void OrdenarPila(Pila<Integer> p) {
		int[] v =  new int[p.getLength()];
		
		//Vacio la pila y lleno el arreglo
		for (int i = 0; p.Retirar(); i++) {
			v[i] = p.getDr();
		}
		
		//Ordenar el arreglo:
		int aux = 0;
		boolean band = false;
		while(!band) {
			band =  true;
			for (int i = 0; i < v.length-1; i++) {
				if(v[i] < v[i+1]) {
					aux = v[i];
					v[i] = v[i+1];
					v[i+1] = aux;
					band = false;
				}
			}
		}
		//Volver a llenar la pila:
		int j = 0;
		while(!p.Llena()) {
			p.Insertar(v[j]);
			j++;
		}
	}
	
	private static void Imprime(Pila<Integer> p) {
		Pila<Integer> pilaAux=new Pila(p.getLength());
		while(p.Retirar() && pilaAux.Insertar(p.getDr())) {
			System.out.println(p.getDr());
		}
		while(pilaAux.Retirar() && p.Insertar(pilaAux.getDr()));
		
	}

	public static void CambiarValorP(Pila<Integer> p, int dato, int cambio) {
		Pila<Integer> aux = new Pila<>(p.getLength());
		
		while(p.Retirar()) {
			if(dato != p.getDr()) {
				aux.Insertar(p.getDr());
			}else {
				aux.Insertar(cambio);
			}
		}
		
		while(aux.Retirar() && p.Insertar(aux.getDr()));
	}
}
