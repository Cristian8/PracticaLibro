package ejerci.palindromo;

import java.util.Scanner;

public class Palindromo {
	public static void main(String[] args) {
		String palabra;
		String palabraSinEspacios;
		Palindromo palindromo = null;
		boolean palindromoEncontrado = false;
		
		System.out.println("Introduzca una palabra");
		palabra = pedirPalabra();
		
		palabraSinEspacios = palabra.replace(" ", "");
		
		palindromo = new Palindromo();
		
		palindromoEncontrado = palindromo.comprobarPalindromo(palabraSinEspacios);
		
		if(palindromoEncontrado)
		{
			System.out.println("La palabra es un palindromo");
		}else
		{
			System.out.println("La palabra no es un palindromo");
		}
		
	}

	/**
	 * Devuelve un true si la palabra introducida palabraAComprobar es una palara polindromo
	 * @param palabraAComprobar
	 * @return
	 */
	public boolean comprobarPalindromo(String palabraAComprobar){
		boolean palindromo = true;
		int primeraPosicion = 0;
		int ultimaPosicion = palabraAComprobar.length()-1;
		
		do{
			if(palabraAComprobar.charAt(primeraPosicion) != palabraAComprobar.charAt(ultimaPosicion))
			{
				palindromo = false;
			}	
			
			primeraPosicion++;
			ultimaPosicion --;
		}while (palindromo && primeraPosicion <= ultimaPosicion);
		
		return palindromo;
	}
	
	/**
	 * Metodo que devuelve un string
	 * @return
	 */
	public static String pedirPalabra(){
		String palabraDevuelta;
		
		Scanner scanner = null;
			scanner = new Scanner(System.in);
			palabraDevuelta = scanner.nextLine();

			
		return palabraDevuelta;
	}
		
}