package org.zwx.entity;

import java.util.List;
import java.util.Map;

public class Article {

    private Long id;

    private String content;

    private User user;

    private List<Post> posts;

    private Long point;

    private Map<String, Object> props;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }


    public Map<String, Object> getProps() {
        return props;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", posts=" + posts +
                ", point=" + point +
                ", props=" + props +
                '}';
    }

    public static final class ArticleBuilder {
        private Long id;
        private String content;
        private User user;
        private List<Post> posts;
        private Long point;
        private Map<String, Object> props;

        private ArticleBuilder() {
        }

        public static ArticleBuilder anArticle() {
            return new ArticleBuilder();
        }

        public ArticleBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ArticleBuilder content(String content) {
            this.content = content;
            return this;
        }

        public ArticleBuilder user(User user) {
            this.user = user;
            return this;
        }

        public ArticleBuilder posts(List<Post> posts) {
            this.posts = posts;
            return this;
        }

        public ArticleBuilder point(Long point) {
            this.point = point;
            return this;
        }

        public ArticleBuilder props(Map<String, Object> props) {
            this.props = props;
            return this;
        }

        public Article build() {
            Article article = new Article();
            article.setId(id);
            article.setContent(content);
            article.setUser(user);
            article.setPosts(posts);
            article.setPoint(point);
            article.props = this.props;
            return article;
        }
    }
}
