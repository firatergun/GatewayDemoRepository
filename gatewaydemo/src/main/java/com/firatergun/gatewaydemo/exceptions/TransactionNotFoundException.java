package com.firatergun.gatewaydemo.exceptions;

@SuppressWarnings("serial")
public class TransactionNotFoundException extends RuntimeException{
	
	public TransactionNotFoundException(Long id) {
		super("Transaction with id: " + id + " Not FOUND !..");
	}
}
