package ejerci.recursion;

public class ArgumentoMayor {
	
	/*private static String argumentoMayor(int posicion, String[] args, String argumento_mayor){
	
		if (posicion<args.length)//recursive case
		{
			if (args[posicion].length()>argumento_mayor.length())
			{
				argumento_mayor = argumentoMayor(posicion+1, args, args[posicion]);
			} else argumento_mayor = argumentoMayor(posicion+1, args, argumento_mayor);
		}
		return argumento_mayor;
	}*/
	
	//mayor = argumentoMayor(1, args, args[0]); (va en metodo main)para recursion
	
	public static void main(String[] args) {
		String mayor = null;
		int tamaño_palabra = 0;
		int contador = 0;
		

		for(String palabra: args)//for ech
		{
			if(tamaño_palabra<palabra.length())
			{
				tamaño_palabra = palabra.length();
				mayor = palabra;
			}
			contador++;
		}
		System.out.println("La palabra mayor es: "+mayor);
		System.out.println("El numero de argumentos es: "+contador);
	}

}
