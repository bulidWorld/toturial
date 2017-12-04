package org.zwx.io;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

public class CustomFileVisitor extends SimpleFileVisitor<Path> {

    private List<Path> result;

    private FileVisitPolicy policy;

    public CustomFileVisitor(List<Path> result, FileVisitPolicy policy) {
        this.result = result;
        this.policy = policy;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        Path fileName = path.getFileName();
        boolean bAdd = true;
        do {
            if (StringUtils.isNotBlank(policy.startWithStr)) {
                if (!fileName.startsWith(policy.startWithStr)) {
                    bAdd = false;
                    break;
                }
            }

            if (StringUtils.isNoneBlank(policy.endWithStr)) {
                if (!fileName.endsWith(policy.endWithStr)) {
                    bAdd = false;
                    break;
                }
            }

            if (policy.fileSize != null) {
                //plicy's file size is kb
                if (attrs.size() < policy.fileSize * 1024) {
                    bAdd = false;
                    break;
                }
            }

            Instant lastAccessInstant = attrs.lastAccessTime().toInstant();
            if (policy.beforeSec != null) {
                if (Instant.now().minusSeconds(policy.beforeSec).compareTo(lastAccessInstant) > 0) {
                    bAdd = false;
                    break;
                }
            }

            if (policy.beforeInstant != null) {
                if (policy.beforeInstant.compareTo(lastAccessInstant) > 0) {
                    bAdd = false;
                    break;
                }
            }

            if (policy.afterInstant != null) {
                if (policy.afterInstant.compareTo(lastAccessInstant) < 0) {
                    bAdd = false;
                    break;
                }
            }
        } while (false);

        if (bAdd) {
            result.add(path);
        }
        return CONTINUE;
    }
}
