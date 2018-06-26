package org.zwx.entity;

import java.util.Date;

public class Post {

    private Long id;

    private String commence;

    private Date date;

    public Long getId() {
        return id;
    }

    public String getCommence() {
        return commence;
    }

    public Date getDate() {
        return date;
    }


    public static final class PostBuilder {
        private Long id;
        private String commence;
        private Date date;

        private PostBuilder() {
        }

        public static PostBuilder aPost() {
            return new PostBuilder();
        }

        public PostBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public PostBuilder commence(String commence) {
            this.commence = commence;
            return this;
        }

        public PostBuilder date(Date date) {
            this.date = date;
            return this;
        }

        public Post build() {
            Post post = new Post();
            post.id = this.id;
            post.date = this.date;
            post.commence = this.commence;
            return post;
        }

        @Override
        public String toString() {
            return "PostBuilder{" +
                    "id=" + id +
                    ", commence='" + commence + '\'' +
                    ", date=" + date +
                    '}';
        }
    }
}
