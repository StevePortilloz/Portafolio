package Recursividad;


public class Potencia {
    public static void main(String[] args) {
        
        int base = 5, potencia = 3;
        System.out.println("\n\tResultado: "+BasePotencia(base, potencia)+"\n\n\n");
    }

    public static int BasePotencia(int b, int p) {

    if (p == 0) return 1;
    return b * BasePotencia(b, p-1);
    }
}
