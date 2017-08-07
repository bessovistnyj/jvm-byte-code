
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
                    addOrderToBook(streamReader);
                } else if (streamReader.getLocalName().equals("DeleteOrder")) {
                    deleteOrder(streamReader);
                }

            }
            streamReader.next();
        }
        int a =1;

    }

    /**
     *
     * @param stream
     */
    private void addOrderToBook(XMLStreamReader stream) {
        String bookNumber = stream.getAttributeValue(0);
        String operation = stream.getAttributeValue(1);
        Double price = Double.valueOf(stream.getAttributeValue(2));
        Integer volume = Integer.valueOf(stream.getAttributeValue(3));
        Integer id = Integer.valueOf(stream.getAttributeValue(4));
        boolean typeOperation = false;
        OrderBook newOrderBook;
        if (operation.equals("BUY")) {
            typeOperation = true;
        } else {
            typeOperation = false;
        }

        Order newOrder = new Order(typeOperation,price,volume,id);

        if (!this.orderBooks.containsKey(bookNumber)) {
            newOrderBook = new OrderBook();
            this.orderBooks.put(bookNumber,newOrderBook);
        } else {
            newOrderBook = this.orderBooks.get(bookNumber);

        }
        newOrderBook.addOrder(newOrder);

    }

    private void deleteOrder(XMLStreamReader stream) {
        String bookNumber = stream.getAttributeValue(0);
        Integer id = Integer.valueOf(stream.getAttributeValue(1));
        this.orderBooks.get(bookNumber).deleteOrder(id);
    }


}
