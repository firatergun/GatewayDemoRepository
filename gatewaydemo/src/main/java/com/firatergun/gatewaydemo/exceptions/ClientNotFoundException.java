package com.firatergun.gatewaydemo.exceptions;

@SuppressWarnings("serial")
public class ClientNotFoundException extends RuntimeException{
	
	public ClientNotFoundException(Long id) {
		super("Client with id: " + id + " NOT FOUND !..");
	}
}
