package Estaticas;

public class Pila <T> {
	private int max;
	private T[] arreglo;
	private T dr;
	private int tope;

	public Pila() {
		this(5);
	}

	@SuppressWarnings("unchecked")
	public Pila(int max) {
		this.max = max;
		arreglo = (T[]) new Object[max];
		tope = -1;
	}
	public boolean Insertar(T a) {
		if (Llena()) 
			return false;
		tope++;
		arreglo[tope] = a;
		return true;
	}
	public boolean Retirar() {
		if (Vacia())
			return false;
		dr = arreglo[tope];
		arreglo[tope] = null;
		tope--;
		return true;
	}
	
	public boolean Vacia() {
		return tope == -1;
	}
	public boolean Llena() {
		return tope == max-1;
	}
	public T getDr() {
		return dr;
	}
}
