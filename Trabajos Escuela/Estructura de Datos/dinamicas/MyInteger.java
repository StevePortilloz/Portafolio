package dinamicas;

public class MyInteger {

	private int valor;
	private int tama�o;
	
	public MyInteger(int valor, int tama�o) {
		this.valor=valor;
		this.tama�o = tama�o;
	}
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	public String toString() {
		return Rutinas.PonCeros(valor, tama�o);
	}
	
}
