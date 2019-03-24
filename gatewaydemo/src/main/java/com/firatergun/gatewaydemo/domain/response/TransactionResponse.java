package com.firatergun.gatewaydemo.domain.response;

import java.util.List;

import com.firatergun.gatewaydemo.entity.Transaction;

public class TransactionResponse {
	
	private Integer per_page;
	private Integer current_page;
	private String next_page_url;
	private String prev_page_url;
	private Integer from;
	private Integer to;
	private List<Transaction> data;

	public TransactionResponse() {
	}
	
	public TransactionResponse(Integer per_page, Integer current_page, String next_page_url, String prev_page_url,
			Integer from, Integer to, List<Transaction> data) {
		this.per_page = per_page;
		this.current_page = current_page;
		this.next_page_url = next_page_url;
		this.prev_page_url = prev_page_url;
		this.from = from;
		this.to = to;
		this.data = data;
	}

	public Integer getPer_page() {
		return per_page;
	}

	public void setPer_page(Integer per_page) {
		this.per_page = per_page;
	}

	public Integer getCurrent_page() {
		return current_page;
	}

	public void setCurrent_page(Integer current_page) {
		this.current_page = current_page;
	}

	public String getNext_page_url() {
		return next_page_url;
	}

	public void setNext_page_url(String next_page_url) {
		this.next_page_url = next_page_url;
	}

	public String getPrev_page_url() {
		return prev_page_url;
	}

	public void setPrev_page_url(String prev_page_url) {
		this.prev_page_url = prev_page_url;
	}

	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	public Integer getTo() {
		return to;
	}

	public void setTo(Integer to) {
		this.to = to;
	}

	public List<Transaction> getData() {
		return data;
	}

	public void setData(List<Transaction> data) {
		this.data = data;
	}
}
