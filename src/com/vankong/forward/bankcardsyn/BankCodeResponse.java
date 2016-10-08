/**   
*    
* 项目名称：MicroFinanceGit   
* 类名称：BankCodeResponse   
* 类描述：   
* 创建人：zzy   
* 创建时间：2015年12月14日 下午2:10:27   
* @version        
*/
package com.vankong.forward.bankcardsyn;

import com.vankong.forward.BaseServerResponse;

import java.util.ArrayList;


public class BankCodeResponse extends BaseServerResponse {
	private ArrayList<BankInfoBean> responseData;

	public ArrayList<BankInfoBean> getResponseData() {
		return responseData;
	}

	public void setResponseData(ArrayList<BankInfoBean> responseData) {
		this.responseData = responseData;
	}

	@Override
	public String toString() {
		return "BankCodeResponse [responseData=" + responseData + "]";
	}
	
	

}
