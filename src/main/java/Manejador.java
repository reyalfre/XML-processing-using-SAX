import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Clase Manejador (Handler) que extiende DefaultHandler de SAX
 */
public class Manejador extends DefaultHandler {
    private ArrayList<Empleado> lista = new ArrayList<Empleado>();
    private Empleado em;
    private StringBuilder buffer = new StringBuilder();

    /**
     * Método que se llama cuando se encuentran caracteres entre las etiquetas XML
     * @param ch The characters.
     * @param start The start position in the character array.
     * @param length The number of characters to use from the
     *               character array.
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    /**
     * Método que se llama al finalizar una etiqueta XML
     * @param uri The Namespace URI, or the empty string if the
     *        element has no Namespace URI or if Namespace
     *        processing is not being performed.
     * @param localName The local name (without prefix), or the
     *        empty string if Namespace processing is not being
     *        performed.
     * @param qName The qualified name (with prefix), or the
     *        empty string if qualified names are not available.
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "nombre":
                em.setNombre(buffer.toString().trim());
                break;
            case "edad":
                em.setEdad(Integer.parseInt(buffer.toString().trim()));
                break;
            case "sexo":
                em.setSexo(buffer.toString().trim());
                break;
            case "categoria":
                em.setCategoria(buffer.toString().trim());
                break;
        }
    }

    /**
     * Método que se llama al encontrar una etiqueta de apertura XML
     * @param uri The Namespace URI, or the empty string if the
     *        element has no Namespace URI or if Namespace
     *        processing is not being performed.
     * @param localName The local name (without prefix), or the
     *        empty string if Namespace processing is not being
     *        performed.
     * @param qName The qualified name (with prefix), or the
     *        empty string if qualified names are not available.
     * @param attributes The attributes attached to the element.  If
     *        there are no attributes, it shall be an empty
     *        Attributes object.
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        switch (qName) {
            case "Empleado":
                em = new Empleado();
                lista.add(em);
                em.setId(Integer.parseInt(attributes.getValue("id")));
                break;
            case "nombre":
            case "edad":
            case "sexo":
            case "categoria":
                buffer.delete(0, buffer.length());
                break;
        }
    }

    /**
     * Método que devuelve la lista de empleados construida durante el análisis SAX
     * @return la lista de empleados
     */
    public ArrayList<Empleado> getLista() {
        return lista;
    }
}