package simpe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zwx.simple.HelloWorldClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TestConn {

    @Autowired
    HelloWorldClient helloWorldClient;

    @Test
    public void testSayHello() {
       String resp = helloWorldClient.sayHello("John", "Doe");
       System.err.println(resp);
    }

}
