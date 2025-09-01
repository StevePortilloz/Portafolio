package exam;

public class Lista<T> { //Basica
	
	private   Nodo<T> frente;
	private   Nodo<T> fin;
	private   T       info;
	private   int     length;
	
	public Lista() {
		frente=fin=null;
	}
	
	public boolean Insertar(T dato) {
		Nodo<T> nuevo = new Nodo(dato); 
		length++;
		
		// El Primer nodo
		if( frente==null) {
			frente=fin=nuevo;
			return true;
		}		
		// VER SI EL NUEVO ES MENOR QUE EL QUE ESTA AL FRENTE
		if(nuevo.getInfo().toString().compareTo( frente.getInfo().toString()) <= 0) {
			nuevo.setSig(frente);
			frente=nuevo;
			return true;
		}
		// VER SI EL NUEVO ES MENOR QUE EL QUE ESTA AL FIN
		if(nuevo.getInfo().toString().compareTo( fin.getInfo().toString()) >=0) {
			fin.setSig(nuevo);
			fin=nuevo;
			return true;
		}
		// ENTRE DOS NODOS
		
		Nodo<T> nodoant=null, nodomayor=frente;
		while(nodomayor.getInfo().toString().compareTo(nuevo.getInfo().toString())<0) {
			nodoant = nodomayor;
			nodomayor = nodomayor.getSig();
		}
		nodoant.setSig(nuevo);
		nuevo.setSig(nodomayor);
		return true;
	}
	
	public void mostrar() {
		Nodo aux = frente;
		int i = 1;
		do {
			System.out.println(i+".- " + aux.getInfo());
			aux = aux.getSig();
			i++;
		} while(i <= length);
	}
	
	//Get y Set

	public Nodo<T> getInicio() {
		return frente;
	}

	public void setInicio(Nodo<T> frente) {
		this.frente = frente;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public int getLength() {
		return length;
	}

	public Nodo<T> getFin() {
		return fin;
	}

	public void setFin(Nodo<T> fin) {
		this.fin = fin;
	}
}
