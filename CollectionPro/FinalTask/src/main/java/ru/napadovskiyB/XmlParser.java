
package ru.napadovskiyB;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Package of CollectionPro finalTask.
 * Main class for read xml file.
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 01.08.2017
 */
public class XmlParser {

    /**
     *
     */
    private HashMap<String, OrderBook> orderBooks = new HashMap<>();

    /**
     *
     * @return
     */
    public String getFileName() {
        String fileName = "";

        Settings settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();

        try (InputStream is = loader.getResourceAsStream("app.properties")){
            settings.load(is);

        } catch (Exception ex) {
            ex.getStackTrace();
        }
        fileName = settings.getValue("home.path");
        return fileName;
    }


    /**
     *
     * @throws FileNotFoundException
     * @throws XMLStreamException
     */
    public void readXMLFile() throws FileNotFoundException, XMLStreamException {


        XMLInputFactory factory = XMLInputFactory.newInstance();
        InputStream in = new FileInputStream(getFileName());
        XMLStreamReader streamReader = factory.createXMLStreamReader(in);

        while (streamReader.hasNext()) {
            if (streamReader.isStartElement()) {
                if (streamReader.getLocalName().equals("AddOrder")) {
                    int a =1;
                } else if (streamReader.getLocalName().equals("DeleteOrder")) {
                    int a =1;
                }

            }
            streamReader.next();
        }

    }




}
