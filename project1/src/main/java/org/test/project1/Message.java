package org.test.project1;

public class Message {

	private String message;

	public Message(String msg) {
		this.message = msg;
	}

	public void execute() {
		System.out.println(message);
	}

}
