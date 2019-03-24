package com.firatergun.gatewaydemo.repository;

import java.util.List;

import com.firatergun.gatewaydemo.domain.request.TransactionRequest;
import com.firatergun.gatewaydemo.entity.Transaction;

public interface TransactionRepositoryCustom {
	
	List<Transaction> findByRequest(TransactionRequest request);
	public List<Transaction> findByRequestPaginated(TransactionRequest request);
	public Integer countByRequest(TransactionRequest request);
}
