package com.firatergun.gatewaydemo.domain.response;

import com.firatergun.gatewaydemo.Enum.Currency;

public class ReportData {
	private Integer count;
	private Integer total;
	private Currency currency;
	
	public ReportData() {}
	
	public ReportData(Integer count, Integer total, Currency currency) {
		this.count = count;
		this.total = total;
		this.currency = currency;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
}
