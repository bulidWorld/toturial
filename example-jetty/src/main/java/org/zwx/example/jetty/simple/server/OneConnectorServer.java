package org.zwx.example.jetty.simple.server;

import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.zwx.example.jetty.simple.handler.SimpleHandler;

public class OneConnectorServer {

    public static void main(String[] args) throws Exception {
        Server server = new Server();

        ServerConnector http = new ServerConnector(server);
        http.setHost("localhost");
        http.setPort(8081);
        http.setIdleTimeout(3000);

        server.addConnector(http);
        server.setHandler(new SimpleHandler());

        server.start();
        server.join();
    }
}
