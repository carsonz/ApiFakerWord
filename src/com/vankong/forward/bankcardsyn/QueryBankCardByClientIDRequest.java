package com.vankong.forward.bankcardsyn;

import java.io.Serializable;

public class QueryBankCardByClientIDRequest implements Serializable{
	private static final long serialVersionUID = 6054114996192268704L;
	private String ClientID;

	public String getClientID() {
		return ClientID;
	}

	public void setClientID(String clientID) {
		ClientID = clientID;
	}
	
}
