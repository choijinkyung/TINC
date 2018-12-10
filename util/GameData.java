package util;

import java.io.Serializable;

import client.Client;

public class GameData implements Serializable {
    private String type;
    private String action;
    private int value;
    private String[] data;
    private String word;
    private int turn;
    
    public GameData(String type, String action) {
        this.type = type;
        this.action = action;
    }
    
    public GameData(String type, int value) {
        this.type = type;
        this.value = value;
    }

    public GameData(String type, String action, int value) {
        this.type = type;
        this.action = action;
        this.value = value;
    }
    
    public GameData(String type, String action, String[] data) {
    	this.type = type;
    	this.action = action;
    	this.data = data;
    }
    
    public GameData(String type, String action, String word) {
    	this.type=type;
    	this.action=action;
    	this.word=word;
    }

    public GameData(String type, int turn, int value) {
		// TODO Auto-generated constructor stub
    	this.type=type;
    	this.turn=turn;
    	this.value=value;
	}
    
    public GameData(String type, String action, int value, int turn) {
		// TODO Auto-generated constructor stub
    	this.type=type;
    	this.action=action;
    	this.turn=turn;
    	this.value=value;
	}
    
	public String getAction() {
        return action;
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
    
    public String[] getData() {
    	return data;
    }

    public String getWord() {
    	return word;
    }
    
    public int getTurn() {
    	return turn;
    }
}
