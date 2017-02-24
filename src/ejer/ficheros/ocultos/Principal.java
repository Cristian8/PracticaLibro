package ejer.ficheros.ocultos;

import java.io.File;
					//Mostrar ficheros ocultos

public class Principal {

	public static void main(String[] args) {
		
		File file = null;
		
		file = new File("F:/Progrmacion\\Ejercicios programacion/Ficheros");
		
		//crea array para guardar el metodo .list() q devuelve un array
		//String [] lista = null;
		
		//asignamos al arraay lo q nos devuelve el metodo list()
		//lista = file.list();
		
		/*for(int i = 0; i < lista.length;i++){
			System.out.println(lista[i]);*/
			
		File [] lista = file.listFiles();
			
			for(int i = 0; i < lista.length; i++){
				if(lista[i].isHidden()){
					System.out.println(lista[i].getName());
				}
			}
		

	}

}
