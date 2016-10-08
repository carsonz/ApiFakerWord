package com.vankong.forward.customer;

import java.io.Serializable;

public class CustomerSyncRequest implements Serializable {

	private static final long serialVersionUID = -6034283052915225640L;

	/**
	 * 
	 * 项目名称：MicroFinanceGit 类名称：CustomerSyncRequest 类描述： 创建人：lxf
	 * 创建时间：2015年12月14日 上午11:07:01
	 * 
	 * @version
	 */

	private String employeeID;

	private String syncTime;

	private String recordsetQuantity;

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(String syncTime) {
		this.syncTime = syncTime;
	}

	public String getRecordsetQuantity() {
		return recordsetQuantity;
	}

	public void setRecordsetQuantity(String recordsetQuantity) {
		this.recordsetQuantity = recordsetQuantity;
	}

}
