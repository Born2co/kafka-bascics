package com.kafka.app.model;

public class Message {
	private int id;
	private String description;
	private String priority;
	
	public Message() {}
	
	public Message(int id, String description, String priority) {
		super();
		this.id = id;
		this.description = description;
		this.priority = priority;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	
	

}
