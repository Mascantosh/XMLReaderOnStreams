package com.company.xml;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class XMLReader {
    private final XMLStreamReader reader;

    public XMLReader(InputStream stream) throws XMLStreamException {
        reader = factory().createXMLStreamReader(new BufferedReader(new InputStreamReader(stream)));
    }

    public XMLReader(String path) throws FileNotFoundException, XMLStreamException {
        this(new File(path));
    }

    public XMLReader(File file) throws XMLStreamException, FileNotFoundException {

        reader = factory().createXMLStreamReader(new BufferedReader(new FileReader(file)));
    }

    private XMLInputFactory factory() {
        final XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        xmlInputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, false);

        return xmlInputFactory;
    }

    public Stream<Integer> events() {
        Iterator<Integer> it = new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                try {
                    return reader.hasNext();
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
                return false;
            }

            @Override
            public Integer next() {
                try {
                    return reader.next();
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }

                throw new NoSuchElementException();
            }
        };

        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
                it, Spliterator.ORDERED | Spliterator.NONNULL), false);

    }

    public String getTagName() {
        return reader.getLocalName();
    }

    public String getTagText() {
        return reader.getText();
    }
}
