package com.firatergun.gatewaydemo.service;

import org.springframework.stereotype.Service;

import com.firatergun.gatewaydemo.entity.CustomerInfo;
import com.firatergun.gatewaydemo.entity.Transaction;
import com.firatergun.gatewaydemo.exceptions.ClientNotFoundException;
import com.firatergun.gatewaydemo.repository.TransactionRepository;

@Service
public class ClientService {
	
	private TransactionRepository repository;
	
	public ClientService(TransactionRepository repository) {
		this.repository = repository;
	}
	
	public CustomerInfo getClient(Long transactionId) throws Exception{
		Transaction transaction = repository.findById(transactionId).orElseThrow(() -> new ClientNotFoundException(transactionId));
		return transaction.getCustomerInfo();
	}

}
