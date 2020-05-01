package com.fiscord.litmus.common.model;

public class OAuthProvidedUser {
    private String userName;
    private String clientName;
    private String userAttributes;

    public OAuthProvidedUser(String userName, String clientName, String userAttributes) {
        this.userName = userName;
        this.clientName = clientName;
        this.userAttributes = userAttributes;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getUserAttributes() {
        return userAttributes;
    }

    public void setUserAttributes(String userAttributes) {
        this.userAttributes = userAttributes;
    }
}
