package dinamicas;

public class Lista<T> { //Basica
	
	private   Nodo<T> frente;
	private   Nodo<T> fin;
	private   T       dr;
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

}
