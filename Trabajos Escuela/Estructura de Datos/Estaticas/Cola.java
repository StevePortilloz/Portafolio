package Estaticas;
public class Cola <T> {

    private T[] cola;
	private T dr;
	private int frente;
	private int fin;
	private int max;

	public Cola() {
		this(10); //Tamaño estatico en caso de no definir el tamaño de la cola
	}

	public Cola(int max) { // constructor
		this.max = max;
		cola = (T[]) new Cola[max];
		frente = fin = -1;
		
	}
	
	public boolean Vacia() {
		return frente == -1;
	}
	
	public boolean Llena() {
		return fin == max-1;
	}
	
	public boolean Insertar(T dato) {
		if (Llena())
			return false;
		if (Vacia())
			frente = 0;
		fin++;
		cola[fin] = dato;
		return true;
		
	}
	
	public boolean Retirar() {
		if (Vacia())
			return false;
		dr = cola[frente];
		cola[frente] = null;
		if (frente == fin) {
			frente = fin = -1;
		}else {
			frente++;
		}
		return true;
	}
	
	public T getDr() {
		return dr;
	}

    
}
