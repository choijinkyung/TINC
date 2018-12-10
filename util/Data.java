package util;

import client.UserInfo;

import java.io.Serializable;

public class Data implements Serializable {
    private final String type;
    private final String action;
    private String message;
    private String[] words;
    private UserInfo userInfo;

    public Data(String type, String action) {
        this.type = type;
        this.action = action;
    }

    public Data(String type, String action, String message) {
        this.type = type;
        this.action = action;
        this.message = message;
    }
    
    public Data(String type, String action, String[] words) {
        this.type = type;
        this.action = action;
        this.words = words;
    }

    public Data(String type, String action, UserInfo userInfo) {
        this.type = type;
        this.action = action;
        this.userInfo = userInfo;
    }

    public String getType() {
        return type;
    }

    public String getAction() {
        return action;
    }

    public String getMessage() {
        return message;
    }
    
    public String[] getWord() {
    	return words;
    }
    public UserInfo getUserInfo() {
        return userInfo;
    }
    
}
