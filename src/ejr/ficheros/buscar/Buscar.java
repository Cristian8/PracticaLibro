package ejr.ficheros.buscar;

import java.io.File;

public class Buscar {

	public static boolean palabraTieneA (String palabra)
	{
		boolean tieneA = false;
		int indice = 0;
		int longi = palabra.length();
		char car_aux = 0;
		
		while ((!tieneA)&&(indice<longi))
		{
			car_aux = palabra.charAt(indice);
			if ((car_aux=='a') ||(car_aux=='A'))
			{
				tieneA = true;
			}
			indice++;
		}
		return tieneA;
	}
		
	
	public static void main(String[] args) {
		
		File file = new File("F:/Progrmacion\\Ejercicios programacion/Ficheros");
		
		String [] lista = null;
		
		
		lista = file.list();
		
	
		
		for(int i = 0; i < lista.length; i++){
			while((lista[i].charAt(i) != 'a'||lista[i].charAt(i)!='A') &&(i < lista[i].length()))
				
					System.out.println(lista[i]);
				
		}
		
	}

}
