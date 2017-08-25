package org.zwx.example.jetty.simple.server;

import org.eclipse.jetty.server.Server;
import org.zwx.example.jetty.simple.handler.SimpleHandler;

public class HttpServer {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);

        server.setHandler(new SimpleHandler());

        server.start();
        server.join();
    }

}
