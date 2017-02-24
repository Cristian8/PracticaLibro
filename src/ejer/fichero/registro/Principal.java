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
	
	public static String pedirContraseña(){
		String c_introducida = null;
		Scanner scanner = null;
			scanner = new Scanner(System.in);
			System.out.println("Introduce una contraseña: ");
			c_introducida = scanner.nextLine();
		
		return c_introducida;	
	}
	
	public static boolean compararContraseña(String contraseña1, String contraseña2){
		boolean compara = true;
		
	
			if(contraseña1.equals(contraseña2)){
					System.out.println("Contraseña correcta");
			}else{
				compara = false;
				System.out.println("Introduce la misma contraseña");
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
		FileWriter fw_contraseña = null;
		BufferedWriter bw_contraseña = null;
		String nombre = null;
		String contraseña1 = null;
		String contrasena2 = null;
			try
			{
				fw_usuario = new FileWriter("Usuario");
				bw_usuario = new BufferedWriter(fw_usuario);
				nombre = pedirNombre();
				
				fw_contraseña = new FileWriter("Contraseña");
				bw_contraseña = new BufferedWriter(fw_contraseña);
				do{
					contraseña1 = pedirContraseña();
					contrasena2 = pedirContraseña();
				}while(!contraseña1.equals(contrasena2));	
				
				if(compararContraseña(contraseña1, contrasena2)){
					
					bw_usuario.write(nombre);
					contraseña1 = codifica(contraseña1);
					bw_contraseña.write(contraseña1);
					
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
					bw_contraseña.close();
					fw_contraseña.close();
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
		FileReader fr_contraseña = null;
		BufferedReader br_contraseña = null;
		String nombre_pedido = null;
		String contraseña_pedida = null;
		String nombre_leido = null;
		String contraseña_leida = null;
		String contraseña_decodificada = null;
			try{
				fr_usuario = new FileReader("Usuario");
				br_usuario = new BufferedReader(fr_usuario);
				nombre_pedido = pedirNombre();
				fr_contraseña  = new FileReader("Contraseña");
				br_contraseña = new BufferedReader(fr_contraseña);
				contraseña_pedida = pedirContraseña();
				nombre_leido = br_usuario.readLine();
				contraseña_leida = br_contraseña.readLine();
				contraseña_decodificada = decodifica(contraseña_leida);
				
				if(nombre_leido.equals(nombre_pedido)&&(contraseña_decodificada.equals(contraseña_pedida))){
					System.out.println("Accediendo...");
					ok = true;
				}else{
					System.out.println("Introduzca usuario o contraseña correcta");
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
					br_contraseña.close();
					fr_contraseña.close();
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
		String contraseña = null;
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
