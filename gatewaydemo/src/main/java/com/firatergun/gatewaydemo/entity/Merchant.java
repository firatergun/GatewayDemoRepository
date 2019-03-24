package com.firatergun.gatewaydemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Merchant{

	@Id
	@GeneratedValue
	private Long Id;
	private String name;

	public Merchant() {
	}
	
	public Merchant(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return Id;
	}

	@Override
	public String toString() {
		return "Merchant [Id=" + Id + ", name=" + name + "]";
	}
}
