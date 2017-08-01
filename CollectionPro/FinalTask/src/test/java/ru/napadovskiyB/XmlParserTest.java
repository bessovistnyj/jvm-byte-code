package ru.napadovskiyB;

import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class XmlParserTest {

    @Test
    public void TestReadFile() throws FileNotFoundException, XMLStreamException {
        XmlParser parser = new XmlParser();
        parser.readXMLFile();

    }

}