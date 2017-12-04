package org.zwx.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


public class SimpleErrorHandler implements ErrorHandler {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleErrorHandler.class);

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        LOG.warn("warn",exception.getCause());
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        LOG.error("error", exception.getCause());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        LOG.error("fatal error", exception.getCause());
    }
}
