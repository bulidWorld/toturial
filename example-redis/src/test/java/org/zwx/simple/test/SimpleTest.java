package org.zwx.simple.test;

import org.junit.Test;
import org.zwx.example.simple.Simple;

public class SimpleTest {

    @Test
    public void testConn() {
        Simple st = new Simple();
        st.testConnectRedis();
    }
}
