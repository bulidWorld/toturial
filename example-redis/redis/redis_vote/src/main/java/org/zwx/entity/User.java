package org.zwx.entity;

public class User {
    private Long id;

    private String name;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static final class UserBuilder {
        private Long id;
        private String name;

        private UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public User build() {
            User user = new User();
            user.id = this.id;
            user.name = this.name;
            return user;
        }
    }
}
