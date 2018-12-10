package client;

import java.io.Serializable;

public final class UserInfo implements Serializable {
    private String id;
    private String password;
    private transient String pass;
    private int score=0;
    
    public UserInfo(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void hidePassword() {
        this.pass = this.password;
        this.password = null;
    }
    
    public int getScore() {
    	return score;
    }
    
    public void addScore(int value) {
    	score=score+value;
    }
}
