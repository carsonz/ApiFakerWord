package com.vankong.forward.customer;


import com.vankong.forward.BaseServerResponse;

import java.util.ArrayList;

public class CustomerSyncResponse extends BaseServerResponse {

	private ArrayList<CustomerBean> responseData;

	public ArrayList<CustomerBean> getResponseData() {
		return responseData;
	}

	public void setResponseData(ArrayList<CustomerBean> responseData) {
		this.responseData = responseData;
	}

	@Override
	public String toString() {
		return "CustomerSyncResponse [responseData=" + responseData + "]";
	}

}
