package dinamicas;

public class MyInteger {

	private int valor;
	private int tamaño;
	
	public MyInteger(int valor, int tamaño) {
		this.valor=valor;
		this.tamaño = tamaño;
	}
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	public String toString() {
		return Rutinas.PonCeros(valor, tamaño);
	}
	
}
