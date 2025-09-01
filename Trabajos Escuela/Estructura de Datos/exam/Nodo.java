package exam;

public class Nodo <T> {
	
	private T Info;
	private Nodo<T> Sig;
	private Nodo<T> ant;

	public Nodo(T Dato) {
		Info=Dato;
		Sig=null;
		ant=null;
	}
	public Nodo<T> getSig() {
		return Sig;
	}
	public void setSig(Nodo<T> sig) {
		Sig = sig;
	}
	public Nodo<T> getAnt() {
		return ant;
	}
	public void setAnt(Nodo<T> ant) {
		this.ant = ant;
	}

	public T getInfo(){
		return Info;
	}

}

