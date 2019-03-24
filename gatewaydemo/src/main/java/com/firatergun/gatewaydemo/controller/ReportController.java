package com.firatergun.gatewaydemo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firatergun.gatewaydemo.domain.request.TransactionRequest;
import com.firatergun.gatewaydemo.domain.response.ReportResponse;
import com.firatergun.gatewaydemo.service.ReportService;

@RestController
public class ReportController {
	private ReportService reportService;
	
	public ReportController(ReportService reportService) {
		this.reportService = reportService;
	}
	@PostMapping("/api/v3/transactions/report")
	public ReportResponse report(@RequestBody TransactionRequest reportRequest){
		return reportService.getReport(reportRequest);
	}
}
