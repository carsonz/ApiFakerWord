package com.vankong.forward.bankcardsyn;

import java.util.List;

import com.vankong.forward.BaseServerResponse;

public class QueryCustomerBankResponse extends BaseServerResponse {
	private List<BankCardBean> responseData;

	public List<BankCardBean> getResponseData() {
		return responseData;
	}

	public void setResponseData(List<BankCardBean> responseData) {
		this.responseData = responseData;
	}
	
}
