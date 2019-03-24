package com.firatergun.gatewaydemo.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.firatergun.gatewaydemo.Enum.Currency;

@Entity
@Table(name="fx")
public class Fx {

	@Id
	@GeneratedValue
	private Long Id;
	
	private Integer originalAmount;
	
	@Enumerated(EnumType.STRING)
	private Currency originalCurrency;

	public Fx() {}
	
	public Fx(Integer originalAmount, Currency originalCurrency) {
		this.originalAmount = originalAmount;
		this.originalCurrency = originalCurrency;
	}

	public Integer getOriginalAmount() {
		return originalAmount;
	}

	public void setOriginalAmount(Integer originalAmount) {
		this.originalAmount = originalAmount;
	}

	public Currency getOriginalCurrency() {
		return originalCurrency;
	}

	public void setOriginalCurrency(Currency originalCurrency) {
		this.originalCurrency = originalCurrency;
	}

	public Long getId() {
		return Id;
	}

	@Override
	public String toString() {
		return "Fx [Id=" + Id + ", originalAmount=" + originalAmount + ", originalCurrency=" + originalCurrency + "]";
	}
}
