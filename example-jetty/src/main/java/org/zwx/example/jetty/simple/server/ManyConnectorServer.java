package org.zwx.example.jetty.simple.server;

import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.zwx.example.jetty.simple.handler.SimpleHandler;

import java.io.File;


/**
 * many Connector include https connector
 */
public class ManyConnectorServer
{

    public static void main(String[] args) throws Exception
    {

        String keyStorePath = System.getenv("example.keyStore");

        File keyStoreFile = new File(keyStorePath);
        if (! keyStoreFile.exists()) throw new RuntimeException("key store file not exist!!");

        //Http Config
        Server server = new Server();

        HttpConfiguration http_config = new HttpConfiguration();
        ServerConnector httpConn = new ServerConnector(server, new HttpConnectionFactory(http_config));
        httpConn.setPort(8081);
        httpConn.setIdleTimeout(3000);


        //Https Config
        HttpConfiguration https_config = new HttpConfiguration(http_config);

        SecureRequestCustomizer src = new SecureRequestCustomizer();
        src.setStsIncludeSubDomains(true);
        src.setStsMaxAge(3000);
        https_config.addCustomizer(src);

        SslContextFactory sslContextFactory = new SslContextFactory();
        sslContextFactory.setKeyStorePath(keyStoreFile.getAbsolutePath());
        sslContextFactory.setKeyStorePassword("pass");
        sslContextFactory.setKeyManagerPassword("managePass");

        ServerConnector httpsConn = new ServerConnector(server
                , new SslConnectionFactory(sslContextFactory, HttpVersion.HTTP_1_1.asString()), new HttpConnectionFactory(https_config));

        // add http and https connectors
        server.setConnectors(new Connector[]{});


        server.setHandler(new SimpleHandler());
        server.start();
        server.join();
    }
}
