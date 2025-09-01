package exam;

//Autores:
/*-Lie Norzagaray Luis Carlos
 *-Yuliana
 *-Toño (Pongan sus nombres completos)
 * */

//Objetivo: Con una lista de tipo alumnos:
/*1.- Obtener el total de hombres y mujeres
 *2.- Obtener el alumno con mayor edad
 *3.- Mostrar la lista de fin a inicio
 * */

public class ExamLista {

	public static void main(String[] args) {

		Lista<Alumno> listaAlumnos = new Lista<>();

		listaAlumnos.Insertar(new Alumno("A1", "JOSE", 16, 'M'));
		listaAlumnos.Insertar(new Alumno("A2", "LUISA", 20, 'F'));
		listaAlumnos.Insertar(new Alumno("A3", "MARIO", 18, 'M'));
		listaAlumnos.Insertar(new Alumno("A4", "JESUS", 29, 'M'));
		listaAlumnos.Insertar(new Alumno("A5", "EDUARDO", 16, 'M'));
		listaAlumnos.Insertar(new Alumno("A6", "MARIA", 17, 'F'));

		//1.- Obtener total de Hombres y Mujeres:
		TotalHombresYMujeres(listaAlumnos);

		//2.- Obtener el alumno Mayor
		AlumnoMayor(listaAlumnos);
		
		//3.- Mostar la lista de fin a inicio
		System.out.println("En Orden");
		listaAlumnos.mostrar();
		System.out.println("\nMostar Fin a inicio:");
		MostrarFinAInicio2(listaAlumnos);

	}

	public static void TotalHombresYMujeres(Lista<Alumno> lista){
		Nodo<Alumno> aux = lista.getInicio();
		//		Alumno aux = lista.getInicio().getInfo();
		//		while(aux. != lista.getFin().getInfo()) {
		int contWoman= 0, contMan= 0;
		while(contWoman + contMan != lista.getLength()) {

			if(aux.getInfo().getSexo() == 'F') {
				contWoman++;
			}
			if(aux.getInfo().getSexo() == 'M') {
				contMan++;
			}

			aux = aux.getSig();
		}
		System.out.println("TOTAL DE MUJERES Y HOMBRES:");
		System.out.println("\t- Cantidad de Hombres: "+ contMan);
		System.out.println("\t- Cantidad de Mujeres: "+ contWoman);
	}

	public static void AlumnoMayor(Lista<Alumno> lista) {

		Alumno mayor = lista.getInicio().getInfo();
		Nodo<Alumno> aux = lista.getInicio().getSig();

		while(aux != lista.getFin()) {
			if(mayor.getEdad() < aux.getInfo().getEdad()) {
				mayor = aux.getInfo();
			}else {
				aux = aux.getSig();
			}
		}
		System.out.println("EL ALUMNO MAYOR: ");
		System.out.println("\tMatricula\tNombre\tEdad\tSexo");

		System.out.println("\t+ "+ mayor.toString());

	}

	public static void MostrarFinAInicio(Lista<Alumno> lista) {
		Pila<Alumno> save = new Pila<>(lista.getLength());
		Nodo<Alumno> aux = lista.getInicio();
		int i = 0;

		//Guardo los datos
		while(!save.Llena()) {
			save.Insertar(aux.getInfo());
			aux = aux.getSig();
		}
		//Vacio la pila y se imprime la pila
		while(!save.Vacia()) {
			save.Retirar();
			i++;
			System.out.println(i+".-" + save.getDr());
		}

	}

	public static void MostrarFinAInicio2(Lista<Alumno> lista) {
		Nodo<Alumno> aux = lista.getInicio();
		Alumno[] alum = new Alumno[lista.getLength()];
		int j = 0;

		for (int i = 0; i < alum.length; i++) {
			alum[i] = aux.getInfo();
			aux = aux.getSig();
		}
		for (int i = lista.getLength()-1; i >= 0; i--) {
			j++;
			System.out.println(j+".- "+ alum[i]);

		}
	}
}
