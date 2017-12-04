package org.zwx.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.net.URL;
import java.nio.file.Path;

public class XmlParser {

    public static Element parseXML(Path path, URL schemaURL) {

        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        Element root = null;

        try {
            Schema schema = schemaFactory.newSchema(schemaURL);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setSchema(schema);
            SAXParser saxParser = factory.newSAXParser();
            SAXReader saxReader = new SAXReader(saxParser.getXMLReader());
            saxReader.setValidation(false);
            saxReader.setErrorHandler(new SimpleErrorHandler());
            Document document = saxReader.read(path.toFile());
            root = document.getRootElement();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return root;
    }


}
