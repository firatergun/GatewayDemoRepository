package com.firatergun.gatewaydemo.domain.request;

import java.util.Date;
import java.util.Optional;

import com.firatergun.gatewaydemo.Enum.Status;

public class MerchantRequest {
	private Optional<String> name = Optional.ofNullable("_");
	private Optional<Integer> page = Optional.ofNullable(0);
	private Optional<Date> fromDate = Optional.empty();
	private Optional<Date> toDate = Optional.empty();
	private Optional<Status> status = Optional.empty();
	
	public Optional<String> getName() {
		return name;
	}
	public Optional<Integer> getPage() {
		return page;
	}
	public Optional<Date> getFromDate() {
		return fromDate;
	}
	public Optional<Date> getToDate() {
		return toDate;
	}
	public Optional<Status> getStatus() {
		return status;
	}
	
//	public String getName() {
//		return name.orElse("_");
//	}
//	public Integer getPage() {
//		return page.orElse(0);
//	}
//	public Date getFromDate() {
//		return fromDate.isPresent() ? fromDate.get() : Optional.empty().get();
//	}
//	public Date getToDate() {
//		return toDate.orElse(null);
//	}
//	public Status getStatus() {
//		return status.orElse(null);
//	}
	
	
}
