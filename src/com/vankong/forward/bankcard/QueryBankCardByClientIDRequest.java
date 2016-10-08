package com.vankong.forward.bankcard;

import java.io.Serializable;

public class QueryBankCardByClientIDRequest implements Serializable{

	private static final long serialVersionUID = 6054114996192268704L;
	private String ClientID;
	private String cust_id;

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getClientID() {
		return ClientID;
	}

	public void setClientID(String clientID) {
		ClientID = clientID;
	}
	
}
