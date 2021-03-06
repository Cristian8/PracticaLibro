package ejer.fichero.registro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Principal {
	public static final int CLAVE = 9;
	
	public static String pedirNombre(){
		String n_introducido = null;
		Scanner scanner = null;
			scanner = new Scanner(System.in);
			System.out.println("Introduce un Nombre de Usuario: ");
			n_introducido = scanner.nextLine();
		return n_introducido;	
	}
	
	public static String pedirContraseņa(){
		String c_introducida = null;
		Scanner scanner = null;
			scanner = new Scanner(System.in);
			System.out.println("Introduce una contraseņa: ");
			c_introducida = scanner.nextLine();
		
		return c_introducida;	
	}
	
	public static boolean compararContraseņa(String contraseņa1, String contraseņa2){
		boolean compara = true;
		
	
			if(contraseņa1.equals(contraseņa2)){
					System.out.println("Contraseņa correcta");
			}else{
				compara = false;
				System.out.println("Introduce la misma contraseņa");
			}
		return compara;
	}
	
	public static String codifica (String palabra)//El metodo es static xq el resultado es identico el objeto no varia de uno a otro
	{
		String cadena = "";
		int longi = palabra.length();
		char caracter = 0;
		int caracter_n = 0;
		char caracter_cifrado = 0;
		
			for (int i = 0; i < longi; i++) {
				
				caracter = palabra.charAt(i);
				caracter_n = (int)caracter;
				caracter_cifrado = (char) (caracter_n + CLAVE);
			
				cadena = cadena +caracter_cifrado;
			}	

	return cadena;
	}
	
	public static boolean registrarse(){
		boolean ok = true;
		FileWriter fw_usuario = null;
		BufferedWriter bw_usuario = null;
		FileWriter fw_contraseņa = null;
		BufferedWriter bw_contraseņa = null;
		String nombre = null;
		String contraseņa1 = null;
		String contrasena2 = null;
			try
			{
				fw_usuario = new FileWriter("Usuario");
				bw_usuario = new BufferedWriter(fw_usuario);
				nombre = pedirNombre();
				
				fw_contraseņa = new FileWriter("Contraseņa");
				bw_contraseņa = new BufferedWriter(fw_contraseņa);
				do{
					contraseņa1 = pedirContraseņa();
					contrasena2 = pedirContraseņa();
				}while(!contraseņa1.equals(contrasena2));	
				
				if(compararContraseņa(contraseņa1, contrasena2)){
					
					bw_usuario.write(nombre);
					contraseņa1 = codifica(contraseņa1);
					bw_contraseņa.write(contraseņa1);
					
				}
					
			}catch (Exception e) {
				System.out.println("Error al guardar usuario");
				e.printStackTrace();
				ok = false;
			}
			finally 
			{
				try {
					bw_usuario.close();
					fw_usuario.close();
					bw_contraseņa.close();
					fw_contraseņa.close();
				} catch (Exception e) {
					System.out.println("Error al registrarse");
					e.printStackTrace();
					ok = false;
				}
				
			}
		
		return ok;
	}
	
	public static String decodifica (String palabra)
	{
		String cadena = "";
		int longi = palabra.length();
		char caracter = 0;
		int caracter_n = 0;
		char caracter_cifrado = 0;
		
			for (int i = 0; i < longi; i++) {
				caracter = palabra.charAt(i);
				caracter_n = (int)caracter;
				caracter_cifrado = (char) (caracter_n - CLAVE);
			
				cadena = cadena + caracter_cifrado;
			}	
		
	return cadena;
	}
	public static boolean acceder(){
		boolean ok = true;
		FileReader fr_usuario = null;
		BufferedReader br_usuario = null;
		FileReader fr_contraseņa = null;
		BufferedReader br_contraseņa = null;
		String nombre_pedido = null;
		String contraseņa_pedida = null;
		String nombre_leido = null;
		String contraseņa_leida = null;
		String contraseņa_decodificada = null;
			try{
				fr_usuario = new FileReader("Usuario");
				br_usuario = new BufferedReader(fr_usuario);
				nombre_pedido = pedirNombre();
				fr_contraseņa  = new FileReader("Contraseņa");
				br_contraseņa = new BufferedReader(fr_contraseņa);
				contraseņa_pedida = pedirContraseņa();
				nombre_leido = br_usuario.readLine();
				contraseņa_leida = br_contraseņa.readLine();
				contraseņa_decodificada = decodifica(contraseņa_leida);
				
				if(nombre_leido.equals(nombre_pedido)&&(contraseņa_decodificada.equals(contraseņa_pedida))){
					System.out.println("Accediendo...");
					ok = true;
				}else{
					System.out.println("Introduzca usuario o contraseņa correcta");
				}
				
			}catch (Exception e) {
				System.out.println("Error al iniciar sesion");
				e.printStackTrace();
				ok = false;
			}
			finally 
			{
				try {
					br_usuario.close();
					fr_usuario.close();
					br_contraseņa.close();
					fr_contraseņa.close();
				} catch (Exception e) {
					System.out.println("Error al acceder");
					e.printStackTrace();
					ok = false;
				}
				
			}
		
		return ok;
	}
	public static void main(String[] args) {
		
		int a;
		String nombre = null;
		String contraseņa = null;
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("Seleccione una opcion del Menu:\n");
			System.out.println("1- Registrarse ");
			System.out.println("2- Acceder ");
			System.out.println("0- Salir");
			a = scanner.nextInt();
			switch(a){
			
			case 1:
				registrarse();
				break;
			case 2:
				acceder();
				break;
			default:
				System.out.println("Programa cerrado: Adios");
		
			}
		}while(a!=0);
		
	}
}
