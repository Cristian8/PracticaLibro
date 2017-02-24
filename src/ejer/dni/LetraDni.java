package ejer.dni;

import java.util.Scanner;

//Para calcular la letra del DNI, hay un algoritmo, que consiste en obtener el resto de la división entera entre el número dni y 23.
//Esto, nos da un número, cuya posición en la lista de caracteres dada, representa la letra del DNI.
//AYUDA: Usad el código que se adjunta como base de la solución

public class LetraDni {

	public static String caracteresDNI = "TRWAGMYFPDXBNJZSQVHLCKE";// o array de caracteres
	
	public static int pedirDni() {
		int numero_introducido = 0;
		Scanner scanner = null;
		scanner = new Scanner(System.in);
		numero_introducido = scanner.nextInt();
		return numero_introducido;
	}
	
	public static void calcularLetraDni(int numeroDni){
		
		int pos_letra = 0;
		
			pos_letra =numeroDni%23;
			System.out.println(caracteresDNI.charAt(pos_letra));
	}
	
	public static void main(String[] args) {
		long tiempoInicial = System.currentTimeMillis();
		
		int dni_introducido = 0;
		System.out.println("Introduce tu DNI:");
		dni_introducido= pedirDni();
		calcularLetraDni(dni_introducido);
		
		long tiempoFinal = System.currentTimeMillis();
		double segundos = (tiempoFinal-tiempoInicial)/100;
		System.out.println(segundos+"segundos");
	}
	
}
