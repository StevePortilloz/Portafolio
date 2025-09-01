package dinamicas;

public class NodoArbol<T> {

	//Desarrollar clase nodo Arbol
	private NodoArbol<T>   LI;
	private NodoArbol<T>   LD;
	private T info;
	
	public NodoArbol(T valor){ 
		LI=LD=null;
		info=valor;
	}
	
	public NodoArbol<T> getLI() {
		return LI;
	}
	public void setLI(NodoArbol<T> LI) {
		this.LI = LI;
	}
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public NodoArbol<T> getLD() {
		return LD;
	}
	public void setLD(NodoArbol<T> LD) {
		this.LD = LD;
	}   
}
