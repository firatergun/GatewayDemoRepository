package com.firatergun.gatewaydemo.domain.response;

import java.util.List;

import com.firatergun.gatewaydemo.Enum.Status;

public class ReportResponse {
	private Status status;
	private List<ReportData> response;
	
	public ReportResponse(Status status, List<ReportData> response) {
		this.status = status;
		this.response = response;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<ReportData> getResponse() {
		return response;
	}

	public void setResponse(List<ReportData> response) {
		this.response = response;
	}
}
