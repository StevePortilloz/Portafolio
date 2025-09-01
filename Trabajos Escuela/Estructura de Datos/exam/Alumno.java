package exam;

public class Alumno {
	
	private String matricula;
	private String nombre;
	private int edad;
	private char sexo;
	
	public Alumno(String mat, String name, int edad, char sex) {
		matricula = mat;
		nombre = name;
		this.edad = edad;
		sexo =  sex;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return matricula +"\t\t"+ nombre +"\t"+ edad +"\t"+ sexo;
	}
	
	
}
