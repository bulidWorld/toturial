package org.zwx.io;

import java.time.Instant;

public class FileVisitPolicy {

    public final String endWithStr;

    public final String startWithStr;

    public final Long beforeSec;

    public final Instant afterInstant;

    public final Instant beforeInstant;

    //字节为单位
    public final Long fileSize;

    private FileVisitPolicy(Builder builder){
        this.afterInstant = builder.afterInstant;
        this.beforeInstant = builder.beforeInstant;
        this.beforeSec = builder.beforeSec;
        this.endWithStr = builder.endWithStr;
        this.fileSize = builder.fileSize;
        this.startWithStr = builder.startWithStr;
    }


    public static class Builder{

        private String endWithStr;

        private String startWithStr;

        private Long beforeSec;

        private Instant afterInstant;

        private Instant beforeInstant;

        public Long fileSize;

        public Builder endWithStr(String endWithStr) {
            this.endWithStr = endWithStr;
            return this;
        }
        public Builder startWithStr(String startWithStr) {
            this.startWithStr = startWithStr;
            return this;
        }

        public Builder beforeSec(Long beforeSec) {
            this.beforeSec = beforeSec;
            return this;
        }

        public Builder beforInstant(Instant beforeInstant) {
            this.beforeInstant = beforeInstant;
            return this;
        }

        public Builder afterInstant(Instant afterInstant) {
            this.afterInstant = afterInstant;
            return this;
        }

        public Builder fileSize(Long fileSize) {
            this.fileSize = fileSize;
            return this;
        }

        public FileVisitPolicy build() {
            return new FileVisitPolicy(this);
        }

    }


}
