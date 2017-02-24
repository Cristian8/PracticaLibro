package ejer.xml.leer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class MinSAX {

	public static void main(String[] args) throws SAXException, FileNotFoundException, IOException {
		
		XMLReader reader = XMLReaderFactory.createXMLReader();
		ParserLibroXML parserLibreo = null;
		parserLibreo = new ParserLibroXML();
		
		reader.setContentHandler(parserLibreo);
		reader.parse(new InputSource(new FileInputStream("libro.xml")));
	}

}
