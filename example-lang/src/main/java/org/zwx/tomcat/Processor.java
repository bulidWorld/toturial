package org.zwx.tomcat;

public class Processor {
    public void process(Object socket) {

        getHandler().process(socket);
    }

    public Handler getHandler() {
        return handler;
    }
}
