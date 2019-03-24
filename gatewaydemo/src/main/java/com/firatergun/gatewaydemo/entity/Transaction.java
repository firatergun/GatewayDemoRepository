package com.firatergun.gatewaydemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.firatergun.gatewaydemo.Enum.ErrorCode;
import com.firatergun.gatewaydemo.Enum.Operation;
import com.firatergun.gatewaydemo.Enum.PaymentMethod;
import com.firatergun.gatewaydemo.Enum.Status;

@Entity
@Table(name="transactions")
public class Transaction {
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long transactionId;
	
	@ManyToOne()
	@JoinColumn(name="merchant_Id")
	private Merchant merchant;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status;
	
	@Column(name="transactiondate")
	private Date transactionDate;

	@ManyToOne()
	@JoinColumn(name="customerinfo_Id")
	private CustomerInfo customerInfo;
	
	@ManyToOne()
	@JoinColumn(name="acquirer_Id")
	private Acquirer acquirer;
	
	@Enumerated(EnumType.STRING)
	@Column(name="errorcode")
	private ErrorCode errorCode;
	
	@Enumerated(EnumType.STRING)
	@Column(name="paymentmethod")
	private PaymentMethod paymentMethod;
	
	@Enumerated(EnumType.STRING)
	@Column(name="operation")
	private Operation operation;
	
	@ManyToOne()
	@JoinColumn(name="fx_Id")
	private Fx fx;
	
	@Column(name="referenceno")
	private String referenceNo;
		
	public Transaction() {
	}

	public Transaction(Merchant merchant, Status status, Date transactionDate,
			CustomerInfo customerInfo, Acquirer acquirer, ErrorCode errorCode, PaymentMethod paymentMethod,
			Operation operation, Fx fx, String referenceNo) {
		this.merchant = merchant;
		this.status = status;
		this.transactionDate = transactionDate;
		this.customerInfo = customerInfo;
		this.acquirer = acquirer;
		this.errorCode = errorCode;
		this.paymentMethod = paymentMethod;
		this.operation = operation;
		this.fx = fx;
		this.referenceNo = referenceNo;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public Acquirer getAcquirer() {
		return acquirer;
	}

	public void setAcquirer(Acquirer acquirer) {
		this.acquirer = acquirer;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public Fx getFx() {
		return fx;
	}

	public void setFx(Fx fx) {
		this.fx = fx;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", merchant=" + merchant + ", status=" + status
				+ ", transactionDate=" + transactionDate + ", customerInfo=" + customerInfo + ", acquirer=" + acquirer
				+ ", errorCode=" + errorCode + ", paymentMethod=" + paymentMethod + ", operation=" + operation + ", fx="
				+ fx + ", referenceNo=" + referenceNo + "]";
	}
}
