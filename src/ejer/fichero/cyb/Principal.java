package ejer.fichero.cyb;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

	// Crear un fichero con el nombre introducido x el usuario y borrar fichero

	public static String pedirNombreFichero() {
		String nombre_fichero;

		Scanner scanner = null;
		scanner = new Scanner(System.in);
		nombre_fichero = scanner.nextLine();

		return nombre_fichero;
	}
	public static int pedirNumero() {
		int numero_introducido = 0;
		Scanner scanner = null;
		scanner = new Scanner(System.in);
		numero_introducido = scanner.nextInt();
		return numero_introducido;
	}
	
	public static void main(String[] args) throws IOException {
		String ruta = null;
		String nombre_fichero = null;
		int numero_introducido = 0;
	
			System.out.println("1- Crear Archivo:");
			System.out.println("2- Eliminar Archivo");
			numero_introducido = pedirNumero();
			
			System.out.println("Introduce nombre del Archivo:");
			nombre_fichero = pedirNombreFichero();
			
			ruta = "F:/Progrmacion\\Ejercicios programacion/"+nombre_fichero;
			File file = new File(ruta);
			
		switch(numero_introducido){
		case 1:
			if(file.createNewFile()){
				System.out.println("Archivo creado: "+file.getName());
			}else{
				System.out.println("No se ha creado ningun archivo");
			
			}	
			break;
		case 2:
			if (file.delete()){
				System.out.println("Archivo: "+file.getName()+" ha sido eliminado");
			}else{
				System.out.println("El archivo no ha silo eliminado");
			}
			break;
		default:
			System.out.println("Opción incorrecta");
			main(args);
			break;
		
		}
		
		
	}

}
