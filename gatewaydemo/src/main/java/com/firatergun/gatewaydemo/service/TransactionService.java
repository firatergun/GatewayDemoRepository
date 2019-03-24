package com.firatergun.gatewaydemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.firatergun.gatewaydemo.domain.request.TransactionRequest;
import com.firatergun.gatewaydemo.domain.response.TransactionResponse;
import com.firatergun.gatewaydemo.entity.Transaction;
import com.firatergun.gatewaydemo.exceptions.PageRequestOutOfBoundsException;
import com.firatergun.gatewaydemo.exceptions.TransactionNotFoundException;
import com.firatergun.gatewaydemo.repository.TransactionRepository;

@Service
public class TransactionService {
	
	private TransactionRepository repository;
	
	public TransactionService(TransactionRepository repository) {
		this.repository = repository;
	}
	
	public Transaction getTransaction(Long transactionId) {
		return repository.findById(transactionId).orElseThrow(() -> new TransactionNotFoundException(transactionId));
	}
	
	public TransactionResponse getTransactions(TransactionRequest transactionRequest, String requestUrl) {
		Integer transactionCount = repository.countByRequest(transactionRequest);
		int pageNumber = 1;
		int pageSize = 1;
		int pageTotal = 0;
		int from;
		int to;
		String next_page_url = "";
		String prev_page_url = "";
		if(transactionRequest.page != null) {
			pageNumber = transactionRequest.page;
		}
		if(transactionRequest.per_page != null) {
			pageSize = transactionRequest.per_page;
		}
		if(transactionCount > 0) {
			List<Transaction> pagiTransactions = repository.findByRequestPaginated(transactionRequest);
			
			from = (pageNumber-1) * pageSize + 1;
			to = (((pageNumber-1) * pageSize) + pageSize) > transactionCount ? ((pageNumber-1) * pageSize + 1) : (((pageNumber-1) * pageSize) + pageSize);
			pageTotal = (int) ((transactionCount / pageSize) + 1);
			
			if(pageNumber > pageTotal) {
				throw new PageRequestOutOfBoundsException();
			}
			if(pageTotal > 1) {
				if(pageNumber - 1 > 0) {
					prev_page_url =requestUrl + "?page=" + (pageNumber - 1);
				}
				if(pageNumber + 1 < pageTotal) {
					next_page_url = requestUrl + "?page=" + (pageNumber + 1);
				}
			}
			return new TransactionResponse(pageSize, pageNumber, next_page_url, prev_page_url, from, to, pagiTransactions);
		}
		return null;
	}
}
