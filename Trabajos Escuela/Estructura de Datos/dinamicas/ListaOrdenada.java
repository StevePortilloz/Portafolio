package dinamicas;

public class ListaOrdenada<T> {//Doblemente Circular
	
	private Nodo inicio;
	private Nodo fin;
	private int length;
	private T dr;

	public ListaOrdenada() {
		inicio = fin = null;
		dr = null;
	}

	public Nodo<T> getIncio() {
		return inicio;
	}

	//METODO GET Y SET
	public void setInicio(Nodo<T> inicio) {
		this.inicio = inicio;
	}

	public Nodo<T> getFin() {
		return fin;
	}

	public void setFin(Nodo<T> fin) {
		this.fin = fin;
	}

	public T getDr() {
		return dr;
	}
	public int length() {
		return length;
	}

	//FIN METODO GET Y SET

	public boolean insertar(T valor) {
		Nodo nuevo = new Nodo<T>(valor);
		//primer Nodo
		if(inicio==null) {
			inicio=fin=nuevo;
			inicio.setAnt(fin);
			fin.setSig(inicio);
			length++;
			return true;
		}
		// VER SI EL NUEVO ES MENOR QUE EL QUE ESTA AL INICIO
		if( nuevo.getInfo().toString().compareTo(inicio.getInfo().toString()) <= 0 ) {
			nuevo.setSig(inicio);
			nuevo.setAnt(fin);
			inicio.setAnt(nuevo);
			inicio = nuevo;
			fin.setSig(inicio);
			length++;
			return true;
		}
		// VER SI EL NUEVO ES MENOR QUE EL QUE ESTA AL FIN
		if(nuevo.getInfo().toString().compareTo(fin.getInfo().toString()) >= 0) {
			nuevo.setAnt(fin);
			nuevo.setSig(inicio);
			fin.setSig(nuevo);
			inicio.setAnt(nuevo);
			fin = nuevo;
			length++;
			return true;
		}
		//Entre dos nodos
		Nodo nodosig = inicio, nodoant = null;
		while(nodosig.getInfo().toString().compareTo(nuevo.getInfo().toString()) < 0) { //Recorrer la lista en busca de los nodos
			nodoant = nodosig;
			nodosig = nodosig.getSig();
		}
		nuevo.setAnt(nodoant);
		nuevo.setSig(nodosig);
		nodoant.setSig(nuevo);
		nodosig.setAnt(nuevo);
		length++;
		return true;
	}//FIN METODO INSERTAR

	private Nodo buscar(T valor) {
		Nodo aux = inicio;
		boolean flag = true;

		do {
			if(aux.getInfo().toString().compareTo(valor.toString()) == 0) {
				return aux;
			} else if(aux == fin) {
				return null;
			}
		} while(flag);

		return null;
	}

	public void mostrar() {
		Nodo aux = inicio;
		int i = 1;
		do {
			System.out.println(i+".- " + aux.getInfo());
			aux = aux.getSig();
			i++;
		} while(i <= length);
	}


}
