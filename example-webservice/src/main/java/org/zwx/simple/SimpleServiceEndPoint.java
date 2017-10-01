package org.zwx.simple;

import com.codenotfound.types.helloworld.Greeting;
import com.codenotfound.types.helloworld.ObjectFactory;
import com.codenotfound.types.helloworld.Person;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SimpleServiceEndPoint {
    private static final String NAMESPACE_URI = "http://codenotfound.com/types/helloworld";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "person")
    @ResponsePayload
    public Greeting asyHello(@RequestPayload Person request) {
        String greeting = "hello web service " + request.getFirstName() + ":" + request.getLastName();
        ObjectFactory factory = new ObjectFactory();
        Greeting greting = factory.createGreeting();
        greting.setGreeting(greeting);
        return greting;
    }
}
