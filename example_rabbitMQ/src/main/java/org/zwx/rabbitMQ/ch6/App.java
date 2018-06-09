package org.zwx.rabbitMQ.ch6;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class App {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        RPCClient client = new RPCClient();

        String response = client.call("8");
        System.out.println(response);
    }
}
