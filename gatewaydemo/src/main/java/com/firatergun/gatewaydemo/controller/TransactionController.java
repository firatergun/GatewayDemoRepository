package com.firatergun.gatewaydemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firatergun.gatewaydemo.domain.request.TransactionRequest;
import com.firatergun.gatewaydemo.domain.response.TransactionResponse;
import com.firatergun.gatewaydemo.entity.Transaction;
import com.firatergun.gatewaydemo.service.TransactionService;

@RestController
public class TransactionController {
	
	private TransactionService service;
	
	public TransactionController(TransactionService service){
		this.service = service;
	}
	
	@PostMapping("/api/v3/transaction")
	public Transaction transaction(@RequestBody TransactionRequest transactionId) throws Exception {
		return service.getTransaction(transactionId.transactionId);
	}
	
	@PostMapping("/api/v3/transaction/list")
	public TransactionResponse transactionList(@RequestBody TransactionRequest transactionRequest, HttpServletRequest request) throws Exception{
		return service.getTransactions(transactionRequest, request.getRequestURI().toString());
	}

}
