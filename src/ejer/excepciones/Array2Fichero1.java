package ejer.excepciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Leer archivo por lineas, meter en un array y escribir archivo
public class Array2Fichero1 {

	public static String[] fromFichero2Array(File file, String lista_cadena[]) throws IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		for (int i = 0; i < lista_cadena.length; i++) 
		{
			lista_cadena[i]= br.readLine();
			System.out.println(lista_cadena[i]);
		}
		br.close();
		fr.close();
		return lista_cadena;
	}

	public static boolean fromArray2Fichero(String[] array) throws IOException {//INFORMACION DEL FICHERO AL ARRAY
		boolean ok = false;
		FileWriter fw = new FileWriter("texto2");
		BufferedWriter bw = new BufferedWriter(fw);//depende de filewriter pero nadie depende de buffredwriter
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			bw.write(array[i]);
			if(i < array.length-1){
				bw.newLine();
			}
			j++;		
		}
		bw.close();	
		fw.close();
		return ok;
	}
	public static int numerodeLineas(File file) throws IOException{
		
		int contador = 0;
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		while( br.ready()){
			br.readLine();
			contador++;
		}
		br.close();
		fr.close();
		return contador;
	}
	public static void main(String[] args) {
		File file = new File("texto1");
		try  {
			int contador = 0;//numero de lineas
			contador = numerodeLineas(file);
			String[] lista_cadena = new String[contador];
			
			lista_cadena = fromFichero2Array(file,lista_cadena);
			fromArray2Fichero(lista_cadena);
			System.out.println("El numero de lineas es: "+contador);	
		} catch (IOException e) {
			System.out.println("Error : " + e);
		}

	}

	/*private static void leeFichero(BufferedReader br) throws IOException {
		// Leemos el fichero y lo mostramos por pantalla
		String linea = br.readLine();
		while (linea != null) {
			System.out.println(linea);
			linea = br.readLine();
			br.close();
		}
		
	}

	private static void escribeFichero(BufferedWriter bw) throws IOException {
		// Escribimos en el fichero
		bw.write("hola pepe que tal estas");
		bw.newLine();
		bw.write("Cuantos años tienes");
		bw.close();
	}*/

}
