package ejer.fichero.leer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Principal {
	public static void leerArchivo() throws IOException{
		File archivo = new File("pepe");
		FileReader filereader = new FileReader(archivo);
		int a = 0;
		int suma = 0;
		
		a = filereader.read();
		
		while(a != -1){//while((a = archivo.read()) != -1)
			
			suma+= a;
			
			char c = (char) a;
			System.out.println(c +" "+ a);
			a = filereader.read();
			
		}
		System.out.println(suma);
		filereader.close();
	}
	public static void main(String[] args) throws IOException {
		//File archivo = new File("pepe");
		/*FileReader filereader = new FileReader(new File("pepe"));//FileReader file = new FileReader(archivo);
		int a = filereader.read();
		int b = filereader.read();
		
		char c = (char)a;//CASTING: Conversion de tipos equivalentes
		char d = (char)b;
		
		System.out.println(a);
		System.out.println(c);
		System.out.println(b);
		System.out.println(d);*/
		
		leerArchivo();
		
	}

}
