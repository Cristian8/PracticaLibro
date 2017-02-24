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
	
	public static String pedirContrase�a(){
		String c_introducida = null;
		Scanner scanner = null;
			scanner = new Scanner(System.in);
			System.out.println("Introduce una contrase�a: ");
			c_introducida = scanner.nextLine();
		
		return c_introducida;	
	}
	
	public static boolean compararContrase�a(String contrase�a1, String contrase�a2){
		boolean compara = true;
		
	
			if(contrase�a1.equals(contrase�a2)){
					System.out.println("Contrase�a correcta");
			}else{
				compara = false;
				System.out.println("Introduce la misma contrase�a");
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
		FileWriter fw_contrase�a = null;
		BufferedWriter bw_contrase�a = null;
		String nombre = null;
		String contrase�a1 = null;
		String contrasena2 = null;
			try
			{
				fw_usuario = new FileWriter("Usuario");
				bw_usuario = new BufferedWriter(fw_usuario);
				nombre = pedirNombre();
				
				fw_contrase�a = new FileWriter("Contrase�a");
				bw_contrase�a = new BufferedWriter(fw_contrase�a);
				do{
					contrase�a1 = pedirContrase�a();
					contrasena2 = pedirContrase�a();
				}while(!contrase�a1.equals(contrasena2));	
				
				if(compararContrase�a(contrase�a1, contrasena2)){
					
					bw_usuario.write(nombre);
					contrase�a1 = codifica(contrase�a1);
					bw_contrase�a.write(contrase�a1);
					
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
					bw_contrase�a.close();
					fw_contrase�a.close();
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
		FileReader fr_contrase�a = null;
		BufferedReader br_contrase�a = null;
		String nombre_pedido = null;
		String contrase�a_pedida = null;
		String nombre_leido = null;
		String contrase�a_leida = null;
		String contrase�a_decodificada = null;
			try{
				fr_usuario = new FileReader("Usuario");
				br_usuario = new BufferedReader(fr_usuario);
				nombre_pedido = pedirNombre();
				fr_contrase�a  = new FileReader("Contrase�a");
				br_contrase�a = new BufferedReader(fr_contrase�a);
				contrase�a_pedida = pedirContrase�a();
				nombre_leido = br_usuario.readLine();
				contrase�a_leida = br_contrase�a.readLine();
				contrase�a_decodificada = decodifica(contrase�a_leida);
				
				if(nombre_leido.equals(nombre_pedido)&&(contrase�a_decodificada.equals(contrase�a_pedida))){
					System.out.println("Accediendo...");
					ok = true;
				}else{
					System.out.println("Introduzca usuario o contrase�a correcta");
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
					br_contrase�a.close();
					fr_contrase�a.close();
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
		String contrase�a = null;
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
