package ejerci.recursion;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Propiedades {

	public static void main(String[] args /*cuento*/) throws IOException {
		
		Properties fichero_propiedades = null;
		//System.out.println(cuento[0]);
		fichero_propiedades = new Properties();
		FileReader fr = new FileReader("db.properties");
		fichero_propiedades.load(fr);
		
		String vd = fichero_propiedades.getProperty("driver");
		String cd = fichero_propiedades.getProperty("cadena_conexion");
		String us = fichero_propiedades.getProperty("user");
		String pw = fichero_propiedades.getProperty("password");
		//fichero_propiedades.setProperty("palabra", "hola");
		System.out.println(vd+"\n"+cd+"\n"+us+"\n"+pw);
		fr.close();
		//linea de comandos add.(0) equels  String argumentos 
	}

}
