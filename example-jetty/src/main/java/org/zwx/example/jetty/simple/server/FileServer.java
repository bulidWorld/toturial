package org.zwx.example.jetty.simple.server;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;

/**
 * static resource example~~~~
 */
public class FileServer {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setWelcomeFiles(new String[]{"index.html"});
        resourceHandler.setResourceBase("D:/test");
        HandlerList handlerList = new HandlerList(new Handler[]{resourceHandler, new DefaultHandler()});

        server.setHandler(handlerList);
        server.start()  ;
        server.join();
    }
}
