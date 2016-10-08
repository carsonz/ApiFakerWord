package com.vankong.forward.bankcard;


import com.vankong.forward.BaseServerResponse;

public class CreditBankCradResponse extends BaseServerResponse {
	private CreditBankCardBean responseData;

	public CreditBankCardBean getResponseData() {
		return responseData;
	}

	public void setResponseData(CreditBankCardBean responseData) {
		this.responseData = responseData;
	}
}
