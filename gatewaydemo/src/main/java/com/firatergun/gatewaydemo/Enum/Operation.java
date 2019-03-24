package com.firatergun.gatewaydemo.Enum;

public enum Operation {
	//"DIRECT", "REFUND", "3D", "3DAUTH", "STORED"
	DIRECT("DIRECT"),
	REFUND("REFUND"),
	THREED("3D"),
	THREEDAUTH("3DAUTH"),
	STORED("STORED");
	
	private String value;
	
	private Operation(String value){
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
