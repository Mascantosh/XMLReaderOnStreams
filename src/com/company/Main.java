package com.company;

import com.company.xml.XMLReader;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        final InputStream resourceAsStream = Main.class.getClassLoader().getResourceAsStream("reed.xml");

        XMLReader reader = new XMLReader(resourceAsStream);

        reader.events()
                .filter(Main::endElement)
                .map(integer -> reader.getTagName())
                .forEach(System.out::println);
    }

    private static boolean startElement(Integer event) {
        return event == XMLStreamConstants.START_ELEMENT;
    }

    private static boolean endElement(Integer event) {
        return event == XMLStreamConstants.END_ELEMENT;
    }
}
