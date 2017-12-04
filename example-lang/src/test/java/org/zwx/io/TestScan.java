package org.zwx.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

public class TestScan {

    public List<Path> scanFilesInDir(Path dir) throws IOException {
        List<Path> result = new ArrayList<>();
        FileVisitPolicy policy = new FileVisitPolicy.Builder().endWithStr("txt").build();
        Files.walkFileTree(dir, new CustomFileVisitor(result, policy));
        return result;
    }
}

