package dinamicas;

public class Arbol<T> {

	private NodoArbol<T> raiz;
	private NodoArbol<T> padre;
	private NodoArbol<T> item;

	public Arbol() {//Constructor
		raiz = null;
	}

	public NodoArbol<T> getRaiz(){
		return raiz;
	}

	public NodoArbol CreateNodo(T id) {//Crear Nodo
		NodoArbol<T> nuevo = new NodoArbol<T>(id);
		nuevo.setInfo(id);
		nuevo.setLD(null);
		nuevo.setLI(null); 
		return nuevo;
	}

	public boolean Insertar(T dato) {
		return Insertar(raiz, dato);
	}

	private boolean Insertar(NodoArbol nodo, T id) {

		if(Buscar(id)) {
			System.out.println("ERROR, ya existe un nodo con id: "+id);
			return true;
		}

		if(raiz == null) { //Verifica si es el primer nodo/Raiz
			raiz = nodo = CreateNodo(id);
			System.out.println("Se ha insertado la raiz: "+ id);
			return true;
		}
		//Lado Izquierdo
		if(id.toString().compareTo(nodo.getInfo().toString()) < 0) {
			if(nodo.getLI() == null) {
				NodoArbol nuevo = CreateNodo(id);
				nodo.setLI(nuevo);
				System.out.println("se ha insertado el nodo: "+ id);
				return true;
			} else {
				return Insertar(nodo.getLI(), id);
			}
		}
		//LADO DERECHO
		if(id.toString().compareTo(nodo.getInfo().toString()) > 0) {
			if(nodo.getLD() == null) {
				NodoArbol nuevo = CreateNodo(id);
				nodo.setLD(nuevo);
				System.out.println("se ha insertado el nodo: "+ id);
				return true;
			}else {
				return Insertar(nodo.getLD(), id);
			}
		}
		return false;
	}//fin del metodo Insertar

	public boolean Buscar(T dato) {
		return Buscar(raiz, dato, padre);
	}

	private boolean Buscar(NodoArbol nodo, T dato, NodoArbol p) {

		if(nodo != null) {
			if(nodo.getInfo().toString().compareTo(dato.toString()) == 0) {
				if(nodo == raiz) {
					padre = null;
					item = raiz;
					return true;
				}
				padre = p;
				item = nodo;
				return true;

			}else {
				p = nodo;
				if(dato.toString().compareTo(nodo.getInfo().toString()) > 0) {
					return Buscar(nodo.getLD(), dato, p);
				}
				else {
					return Buscar(nodo.getLI(), dato, p);
				}
			}
		}else {
			return false;
		}
	}//fin metodo Buscar

	public boolean Delete(T dato){
		return Delete(raiz, dato);
	}

	private boolean Delete(NodoArbol nodo, T dato) {

		//		Buscar(dato);//dar valor al item y al padre
		if(!Buscar(dato)) {
			System.out.println("ERROR, el elemento a eliminar no existe");
			return false;
		}

		if(item == raiz) {
			//Raiz Hoja(Sin hijos)
			if(raiz.getLD() ==  null && raiz.getLI() == null) {
				raiz.setInfo(null);
				return true;
			}//Fin Raiz hoja.

			//Raiz Con un Hijo
			if(nodo.getLD() != null && nodo.getLI() == null) {
				NodoMenorD(raiz.getLD());

				//Item: Menor del lado D
				//Nodo = raiz;
				item.setLD(raiz.getLD());
				raiz.setLD(null);
				raiz = item;
				return true;

			}else if(nodo.getLI() != null && nodo.getLD() == null){
				NodoMenorD(raiz.getLD());
				item.setLI(raiz.getLD());
				raiz.setLI(null);
				raiz = item;
				return true;
			}//Fin raiz con un hijo.


			//Raiz Con Dos hijos
			if(raiz.getLD() != null && raiz.getLI() != null) {
				NodoArbol datoAux = raiz.getLD().getLD();
				NodoMenorD(raiz.getLD());

				//Item: Menor del lado D
				//Nodo = nodoLD;
				//Raiz = nodo a eliminar
				if(raiz.getLD().getInfo() == item.getInfo()) {
					item.setLI(raiz.getLI());
					item.setLD(datoAux);
					raiz.setLD(null);
					raiz.setLI(null);
					raiz = item;
					return true;
				}else {
					item.setLD(raiz.getLD());
					item.setLI(raiz.getLI());
					raiz.setLD(null);
					raiz.setLI(null);
					raiz = item;
					return true;
				}
			}

		}else {
			//Nodo Hoja(sin hijos)
			if(item.getLD() == null && item.getLI() == null) {

				if(padre.getLD() != null && padre.getLD().getInfo() == item.getInfo())
					padre.setLD(null);

				if(padre.getLI() != null && padre.getLI().getInfo() ==  item.getInfo())
					padre.setLI(null);
				return true;

			}

			//Nodo con un hijo

			if(item.getLI() != null || item.getLD() != null){

				//item = nodo a eliminar
				//padre = padre del item

				if(item.getLI() != null && item.getLD() == null) {
					if(padre.getLI().getInfo() == item.getInfo()) {
						padre.setLI(item.getLI());
						item.setLD(null);
						item.setLI(null);
					}
					else {
						padre.setLD(item.getLI());
						item.setLD(null);
						item.setLI(null);
					}

				}
				if(item.getLD() != null && item.getLI() == null) {
					if(padre.getLD().getInfo() == item.getInfo()) {
						padre.setLI(item.getLD());
						item.setLD(null);
						item.setLI(null);
					}
					else {
						padre.setLD(item.getLD());
						item.setLD(null);
						item.setLI(null);
					}

				}
			}

			//Nodo entre con dos hijos:
			if(item.getLI() != null && item.getLD() != null) {
				NodoMenorD(item.getLD()); //Busca al hijo menor del lado derecho

				nodo = item;

				Buscar(dato);
				/*Item =  nodo actual 25
				 * nodo = nodo hijoD Menor 30
				 * padre = padre del nodo a eliminar.  20
				 * */

				//Buscamos de que lado esta el nodo a eliminar
				if(padre.getLD().getInfo() == item.getInfo()) {
					padre.setLD(nodo);
					//Acomodar el nodo menor LI donde del nodo actual
					nodo.setLI(item.getLI());
					nodo.setLD(item.getLD());
					item.setLD(null);
					item.setLI(null);
					return true;
				}

				if(padre.getLI().getInfo() == item.getInfo()) {
					padre.setLI(nodo);
					//Acomodar el nodo menor LD donde del nodo actual
					nodo.setLI(item.getLI());
					nodo.setLD(item.getLD());
					item.setLD(null);
					item.setLI(null);
					return true;
				}
			}
		}

		return false;
	}//Fin delete


	private boolean NodoMenorD(NodoArbol nodo) {
		if(nodo.getLI() != null) {
			nodo = nodo.getLI();
			return NodoMenorD(nodo);
		}else {
			if(nodo.getLD() != null) {
				T aux = (T) nodo.getLD().getInfo();
				Buscar(aux);
				/* nodo = nodo encontrado con el metodo 30
				 * Item = nodo 25
				 * padre= padre del nodo 20
				 * */

				padre.setLI(nodo.getLD());
				nodo.setLD(null);

			}else {
				T aux = (T) nodo.getInfo();
				Buscar(aux);
				padre.setLI(null);
			}
			item = nodo;
		}

		return false;
	}

	//IMPRESIONES
	public static void InOrden(NodoArbol nodo) { 
		if (nodo != null) {
			InOrden(nodo.getLI());
			System.out.println(nodo.getInfo());
			InOrden(nodo.getLD());	
		}
	}//fin Inorde

	public static void PreOrden(NodoArbol nodo) {
		if (nodo != null) {
			System.out.println(nodo.getInfo());
			PreOrden(nodo.getLI());
			PreOrden(nodo.getLD());
		}
	}//fin PreOrden

	public static void PostOrden(NodoArbol nodo) {
		if (nodo != null) {
			PostOrden(nodo.getLI());
			PostOrden(nodo.getLD());
			System.out.println(nodo.getInfo());
		}
	}

	public int NivelNodo(T dato) {
		int nivel = 1;
		return NivelNodo(raiz, dato, nivel);
	}

	private int NivelNodo(NodoArbol nodo, T dato, int nivel) {
		if(nodo != null) {
			
			if(nodo.getInfo().toString().compareTo(dato.toString()) == 0) {
				return nivel;
				
			}else {
				if(dato.toString().compareTo(nodo.getInfo().toString()) > 0) {
					
					return NivelNodo(nodo.getLD(), dato, ++nivel);
				}
				else {
					return NivelNodo(nodo.getLI(), dato, ++nivel);
				}
			}
		}else {
			return nivel;
		}
	}
	
	public int GradoNodo(T dato) {
		return GradoNodo(raiz, dato, 0);
	}
	
	private int GradoNodo(NodoArbol nodo, T dato, int grado) {
		
		Buscar(dato);
		if(item.getLD() == null && item.getLI() != null) {
			return 0;
		}
		
		//Nodo con un Hijo
		if(item.getLD() != null && item.getLI() == null) {
			return 1;
		}else if(item.getLI() != null && item.getLD() == null) {
			return 1;
		}
		
		//Nodo Con dos Hijos
		if(item.getLD() != null && item.getLI() != null) {
			return 2;
		}
		
		return 0;
	}
}
