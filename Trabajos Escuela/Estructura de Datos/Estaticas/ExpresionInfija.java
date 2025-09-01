package Estaticas;

import java.util.Scanner;

public class ExpresionInfija {

	public static void main(String[] args) {

		System.out.println("Expresión Infija: ");
		String expresion = new Scanner(System.in).nextLine();

		if(expresion.length() == 0)
			return;

		float r=Evalua(expresion);
		System.out.println("Resultado = "+r);
	}

	public static float Evalua(String expresion) {
		Pila<Float> pila = new Pila(5);
		Pila<Character> pilaOperando = new Pila(5);

		char car, operando = 0;

		for(int i=0 ; i < expresion.length(); i++) {

			car=expresion.charAt(i);

			if(Character.isDigit(car)) {	
				boolean res=pila.Insertar(  car-48.0f   );
				if(  !res ) {
					System.out.println("LA EXPRESIÓN NO PUEDE SER RESUELTA, TAMAÑO PILA INADECADO");
					return -1;
				}
			}
			if( "+-*/".indexOf(car) >= 0) {
				if( "*/".indexOf(car) >= 0) {
					operando = car;
					continue;
				}
				pilaOperando.Insertar(car);
			}

			else {
				if(i == expresion.length()-1) {
					while(!pilaOperando.Vacia()) {
						if (!pila.Retirar()) {
							System.out.println("la expresión está incorrecta");
							return -1;
						}
						float parte2=pila.getDr();

						if (!pila.Retirar()) {
							System.out.println("la expresión está incorrecta");
							return -1;
						}
						float parte1=pila.getDr();

						float resultado=0;

						if (operando != 0) {
							switch (operando) {
							case '*': resultado=parte1*parte2; operando = 0; break;
							case '/': resultado=parte1/parte2; operando = 0; break;
							}
						}
						else {
							pilaOperando.Retirar();
							operando = pilaOperando.getDr();
							switch (operando) {
							case '+': resultado=parte1+parte2;break;
							case '-': resultado=parte1-parte2;break;
							}
						}
						pila.Insertar(resultado);
					}
					
				}
			}
		}//Fin for
		pila.Retirar();
		if(!pila.Vacia()) {
			System.out.println("LA EXPRESION ES INCORRECTA");
			return -1;
		}
		return pila.getDr().floatValue();
	}//Fin Metodo
}


