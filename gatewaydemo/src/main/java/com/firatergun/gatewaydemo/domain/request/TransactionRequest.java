package com.firatergun.gatewaydemo.domain.request;

import java.util.Date;

import com.firatergun.gatewaydemo.Enum.ErrorCode;
import com.firatergun.gatewaydemo.Enum.FilterField;
import com.firatergun.gatewaydemo.Enum.Operation;
import com.firatergun.gatewaydemo.Enum.PaymentMethod;
import com.firatergun.gatewaydemo.Enum.Status;

public class TransactionRequest {
	public Date fromDate;
	public Date toDate;
	public Status status;
	public Operation operation;
	public Integer merchantId;
	public Integer acquirerId;
	public PaymentMethod paymentMethod;
	public ErrorCode errorCode;
	public FilterField filterField;
	public String filterValue;
	public Integer page;
	public Integer per_page;
	public Long transactionId;
	
}
