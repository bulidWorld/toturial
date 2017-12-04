package org.zwx.cache;

public class UserAccount {
    private String userId;

    private String userName;

    public UserAccount(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public UserAccount() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
