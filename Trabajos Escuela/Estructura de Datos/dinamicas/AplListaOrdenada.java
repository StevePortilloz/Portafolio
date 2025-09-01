package dinamicas;

public class AplListaOrdenada {

	public static void main(String[] args) {
		
		ListaOrdenada<MyInteger> lista = new ListaOrdenada();

        // 5,6,7,8,9,4,2,5,8 => 2,4,5,6,7,8,9

        lista.insertar(new MyInteger(5, 2));
        lista.insertar(new MyInteger(1, 2));
        lista.insertar(new MyInteger(9, 2));
        lista.insertar(new MyInteger(10, 2));
        lista.insertar(new MyInteger(2, 2));

        lista.mostrar();
		
	}

}
