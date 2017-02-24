package ejer.xml.leer;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParserLibroXML extends DefaultHandler
{	
	private Libro libro;
	private String valor_actual;
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		//super.startDocument();
		System.out.println("INICIO DEL DOCUMENTO");
		System.out.println("Info Libro");
		System.out.println("ISBN = " + libro.getIsbn());
		System.out.println("Autor = " + libro.getAutor());
		System.out.println("Año = " + libro.getAnyo());
		System.out.println("Editorial = " + libro.getEditorial());
		System.out.println("Titulo = " + libro.getTitulo());
	}
	
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		//super.endDocument();
		System.out.println("FIN DEL CUENTO");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
	{
		// TODO Auto-generated method stub
		//super.startElement(uri, localName, qName, attributes);
		System.out.println("StarElement  = "+ localName);
		if(localName.equals("libro")){
			String valor_isbn = attributes.getValue("isbn");
			this.libro.setIsbn(valor_isbn);
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		//super.endElement(uri, localName, qName);
		System.out.println("EndElement  = "+ localName);
		if(localName.equals("Titulo")){
			libro.setTitulo(valor_actual);
		}else if(localName.equals("Autor")){
			libro.setAutor(valor_actual);
		}else if(localName.equals("anyo")){
			libro.setAnyo(valor_actual);
		}else if(localName.equals("editorial")){
			libro.setEditorial(valor_actual);
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		//super.characters(ch, start, length);
		//System.out.println("chaer [] =" +ch);
		System.out.println("Star ="+ start);
		System.out.println("Length ="+ length);
		String str = new String(ch, start, length);
		System.out.println("String = "+ str);
		
	}
	
}
