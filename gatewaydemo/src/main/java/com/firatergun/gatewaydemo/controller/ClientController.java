package com.firatergun.gatewaydemo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firatergun.gatewaydemo.domain.request.TransactionRequest;
import com.firatergun.gatewaydemo.domain.response.ReportResponse;
import com.firatergun.gatewaydemo.entity.CustomerInfo;
import com.firatergun.gatewaydemo.repository.MerchantRepository;
import com.firatergun.gatewaydemo.repository.TransactionRepository;
import com.firatergun.gatewaydemo.service.ClientService;
import com.firatergun.gatewaydemo.service.ReportService;

@RestController
public class ClientController {
	
	private ClientService service;
	
	public ClientController(ClientService service) {
		this.service = service;
	}
	
	@PostMapping("/api/v3/client")
	public CustomerInfo getClient(@RequestBody TransactionRequest transactionId) throws Exception{
		return service.getClient(transactionId.transactionId);
	}
	
//	@PostMapping("/merchants")
//	public ReportResponse report(@RequestBody TransactionRequest reportRequest){
//		return reportService.getReport(reportRequest);
//	}
//	public CustomerInfo getClientt(@RequestBody TransactionRequest transactionId) throws Exception{
//		return service.getClient(transactionId.transactionId);
//	}
//	public TransactionResponse transactionList(@RequestBody TransactionRequest transactionRequest, HttpServletRequest request) throws Exception{
//		return service.getTransactions(transactionRequest, request.getRequestURI().toString());
//	}
}
