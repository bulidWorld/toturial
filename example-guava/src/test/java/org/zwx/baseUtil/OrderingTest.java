package org.zwx.baseUtil;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.Comparator;

public class OrderingTest {

    @Test
    public void test() {
        Ordering.natural();

        Ordering.from((t1, t2) -> 0).reverse().nullsFirst().nullsLast();

        Ordering.natural().greatestOf(Lists.newArrayList(), 5);

    }
}
