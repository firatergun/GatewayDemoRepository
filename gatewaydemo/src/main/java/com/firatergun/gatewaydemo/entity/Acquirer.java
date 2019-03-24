package com.firatergun.gatewaydemo.entity;

import javax.persistence.*;

@Entity
@Table(name="acquirer")
public class Acquirer {

	@Id
	@GeneratedValue
	private Long Id;
	private String name;
	
	public Acquirer() {}

	public Acquirer(String name) {
		super();
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
		return "Acquirer [Id=" + Id + ", name=" + name + "]";
	}
}
