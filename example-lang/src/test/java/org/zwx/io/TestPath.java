package org.zwx.io;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestPath {


    @Test
    public void testRelativize() {
        Path source = Paths.get("D:/test");
        String target = "D:/video";


        //表示source到target是怎么走的
        Path videoPath = source.relativize(Paths.get(target));
        System.out.println(videoPath);
    }
}
