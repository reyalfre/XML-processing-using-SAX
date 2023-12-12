import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase principal que utiliza SAX para analizar el archivo XML y mostrar la información de los empleados
 */
public class SAXTeoria {
    public static void main(String[] args) {
        try {
            //Se localiza donde esta el xml llamado Empleados.xml que está en resources.
            File f = new File("src/main/resources/Empleados.xml");
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            //Se crea un manejador (Handler) que extiende DefaultHandler
            Manejador m = new Manejador();
            // Se realiza el análisis SAX del archivo XML utilizando el manejador
            sp.parse(f, m);
            // Se obtiene la lista de empleados construida por el manejador
            ArrayList<Empleado> lista = m.getLista();
            // Se imprime la información de cada empleado por pantalla
            for (int i = 0; i < lista.size(); i++)
                System.out.println(lista.get(i).toString());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}