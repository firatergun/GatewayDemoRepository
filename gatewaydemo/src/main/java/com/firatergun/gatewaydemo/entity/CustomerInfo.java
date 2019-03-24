package com.firatergun.gatewaydemo.entity;

import javax.persistence.*;

@Entity
@Table(name="customerinfo")
public class CustomerInfo {

	@Id
	@GeneratedValue
	private Long Id;
	
	@Column(name="number")
	private String number;
	
	@Column(name="email")
	private String email;
	
	private String billingFirstName;
	
	private String billingLastName;
	
	public CustomerInfo() {}
	
	public CustomerInfo(String number, String email, String billingFirstName, String billingLastName) {
		super();
		this.number = number;
		this.email = email;
		this.billingFirstName = billingFirstName;
		this.billingLastName = billingLastName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBillingFirstName() {
		return billingFirstName;
	}

	public void setBillingFirstName(String billingFirstName) {
		this.billingFirstName = billingFirstName;
	}

	public String getBillingLastName() {
		return billingLastName;
	}

	public void setBillingLastName(String billingLastName) {
		this.billingLastName = billingLastName;
	}

	public Long getId() {
		return Id;
	}

	@Override
	public String toString() {
		return "CustomerInfo [Id=" + Id + ", number=" + number + ", email=" + email + ", billingFirstName="
				+ billingFirstName + ", billingLastName=" + billingLastName + "]";
	}
}
