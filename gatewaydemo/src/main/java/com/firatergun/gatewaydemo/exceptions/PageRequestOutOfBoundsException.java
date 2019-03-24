package com.firatergun.gatewaydemo.exceptions;

@SuppressWarnings("serial")
public class PageRequestOutOfBoundsException extends RuntimeException{

	public PageRequestOutOfBoundsException(){
		super("Page Number out of Bounds !..");
	}
}
