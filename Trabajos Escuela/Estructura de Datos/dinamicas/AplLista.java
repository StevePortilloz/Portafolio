package dinamicas;

public class AplLista {

	public static void main(String[] args) {
		
		Lista<MyInteger> lista = new Lista();

        // 5,6,7,8,9,4,2,5,8 => 2,4,5,6,7,8,9

        lista.Insertar(new MyInteger(5, 2));
        lista.Insertar(new MyInteger(1, 2));
        lista.Insertar(new MyInteger(9, 2));
        lista.Insertar(new MyInteger(10, 2));
        lista.Insertar(new MyInteger(2, 2));

        lista.mostrar();

	}

}
