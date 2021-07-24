package com.universal.rest.webservices.helloworld;

public class HelloWorldBean{
	private String message;
	private String message2;
	
	
	public HelloWorldBean(String message,String message2) {
		this.message = message;
		this.message2 = message2;
	}



	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getMessage2() {
		return message2;
	}

	public void setMessage2(String message2) {
		this.message2 = message2;
	}



	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + ", message2=" + message2 + "]";
	}

	
	
}
