package org.zwx.baseUtil;

import com.google.common.base.Preconditions;
import org.junit.Test;

public class PreConditionTest {

    @Test
    public void test() {
        Preconditions.checkArgument(true);

        Preconditions.checkNotNull(null);

    }
}
