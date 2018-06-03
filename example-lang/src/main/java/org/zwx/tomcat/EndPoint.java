package org.zwx.tomcat;

public class EndPoint {

    private Request request;

    private Processor processor;

    public Request getRequest() {
        return request;
    }

    public boolean accept() {
        return true;
    }

    public Object getSocket() {
        return socket;
    }

    public void processSocket(Object socket) {
        processor.process(socket);

    }
}
