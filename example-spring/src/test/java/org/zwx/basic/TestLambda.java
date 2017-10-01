package org.zwx.basic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class TestLambda {

    public<T> void consumerMethod(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }


    @Test
    public void testConsumer() {
        Map map = new HashMap();
        map.put("1", "a");
        consumerMethod(map, item -> System.out.println(item));

    }
}
