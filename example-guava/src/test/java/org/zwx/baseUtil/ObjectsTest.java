package org.zwx.baseUtil;

import com.google.common.base.Objects;
import org.junit.Test;



public class ObjectsTest {

    @Test
    public void test() {

        boolean b = Objects.equal("a", "b");

        int hash = Objects.hashCode("a", "b", "c");

        System.out.println(hash);

    }
}
