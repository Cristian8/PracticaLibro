import java.io.FileInputStream;
import java.util.HashMap;


import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class MainLibro {
	
	private static HashMap<String,Libro> mapa_libros;
	
	public static void main(String[] args) throws Throwable {
		
		XMLReader reader = XMLReaderFactory.createXMLReader();
		ParserLibroXML parserlibro = new ParserLibroXML();
		
		reader.setContentHandler(parserlibro);
		
		reader.parse(new InputSource(new FileInputStream("libros.xml")));
		
		mostrar();
		getNLibros();
	}
	
	public static void mostrar(){
		for (String nombre: mapa_libros.keySet())
		{
	    	String value = mapa_libros.get(nombre).toString();
	    	System.out.println(value);
		} 
	}

	public static int getNLibros(){
		int num_libros = 0;
		num_libros = mapa_libros.size();
		System.out.println();
		System.out.println("El numero de libros que hay en el mapa es: " + num_libros);
		return num_libros;
	}
		
	
	public static void setMapaLibros(HashMap<String,Libro> mapaLibros2){
		mapa_libros = mapaLibros2;
	}
}
