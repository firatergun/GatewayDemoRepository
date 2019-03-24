package com.firatergun.gatewaydemo.Enum;

public enum FilterField {
//"Transaction UUID", "Customer Email", "Reference No"
	TRANSACTION_UUID("Transaction UUID"),
	CUSTOMER_EMAIL("Customer Email"),
	REFERENCE_NO("Reference No");
	
	private String text;
	
	private FilterField(String text) {
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
}
