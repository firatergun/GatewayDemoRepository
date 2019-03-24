package com.firatergun.gatewaydemo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.firatergun.gatewaydemo.Enum.Currency;
import com.firatergun.gatewaydemo.Enum.Status;
import com.firatergun.gatewaydemo.domain.request.TransactionRequest;
import com.firatergun.gatewaydemo.domain.response.ReportData;
import com.firatergun.gatewaydemo.domain.response.ReportResponse;
import com.firatergun.gatewaydemo.entity.Fx;
import com.firatergun.gatewaydemo.entity.Transaction;
import com.firatergun.gatewaydemo.repository.TransactionRepository;

@Service
public class ReportService {
	
	private final TransactionRepository transRepo;

	public ReportService(TransactionRepository transRepo) {
		this.transRepo = transRepo;
	}
	
	public ReportResponse getReport(TransactionRequest reportRequest) {
		List<Transaction> transactions = transRepo.findByRequest(reportRequest);
		if(transactions.size() > 0) {
			List<ReportData> reportData = new ArrayList<ReportData>();
			List<Currency> curr = Arrays.asList(Currency.values());
			for(int i = 0; i < curr.size(); i++) {
				Currency c = curr.get(i);
				List<Fx> fList = transactions
									.stream()
									.map(Transaction::getFx)
									.filter(f -> f.getOriginalCurrency() == c)
									.collect(Collectors.toList());
				ReportData rp = new ReportData();
				rp.setCount(fList.size());
				rp.setTotal(fList.stream()
								.map(fx -> fx.getOriginalAmount())
								.collect(Collectors.toList())
								.stream()
								.mapToInt(Integer::intValue)
								.sum());
				rp.setCurrency(c);
				reportData.add(rp);
			}
			return new ReportResponse(Status.APPROVED, reportData);
		} else {
			return new ReportResponse(Status.DECLINED, new ArrayList<ReportData>());
		}
	}
}
