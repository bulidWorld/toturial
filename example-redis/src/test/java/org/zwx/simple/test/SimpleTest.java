package org.zwx.simple.test;

import org.junit.Test;

public class SimpleTest {

    @Test
    public void testConn() {
        Simple st = new Simple();
        st.testConnectRedis();
    }
}
