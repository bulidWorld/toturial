package org.zwx.simple;

import com.codenotfound.types.helloworld.Greeting;
import com.codenotfound.types.helloworld.ObjectFactory;
import com.codenotfound.types.helloworld.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class HelloWorldClient {

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    public String sayHello(String firstName, String lastName) {
        ObjectFactory factory = new ObjectFactory();
        Person person = factory.createPerson();

        person.setFirstName(firstName);
        person.setLastName(lastName);

        Greeting greeting = (Greeting) webServiceTemplate.marshalSendAndReceive(person);

        return greeting.getGreeting();

    }



}
