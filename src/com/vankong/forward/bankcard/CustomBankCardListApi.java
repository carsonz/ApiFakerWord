package com.vankong.forward.bankcard;

import com.alibaba.fastjson.JSON;
import com.vankong.forward.bankcardsyn.*;
import com.vankong.forward.customer.CustomerSyncResponse;
import com.vankong.forward.login.LoginBean;
import com.vankong.forward.login.LoginRequest;
import com.vankong.forward.login.LoginResponse;
import com.vankong.utils.VKHttpAbstract;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;

import java.util.HashMap;

public class CustomBankCardListApi extends VKHttpAbstract{
    @Override
    public void preRequest(String api, String param, HttpPost post) {
        if (param == null || param.trim().length() == 0) return;
        BankCardBean bb = JSON.parseObject(param, BankCardBean.class);
        String empid = (String) JSON.parseObject(param).get("EMP_SID");
        HashMap<String,String> newRequest = new HashMap<String, String>();

        newRequest.put("CustBankcard.cust_id",bb.getClientID());
        newRequest.put("CustBankcard.cust_name",bb.getHolderName());
        newRequest.put("CustBankcard.card_no",bb.getCardNO());
        newRequest.put("CustBankcard.bank_name",bb.getBankCodeNum());
        newRequest.put("CustBankcard.bank_privince",bb.getPrivince());
        newRequest.put("CustBankcard.bank_city",bb.getCity());
        newRequest.put("CustBankcard.card_remark","");
        newRequest.put("CustBankcard.cust_cardid",bb.getId());
        newRequest.put("EMP_SID",empid);

        HttpEntity entity = jsonToForm(JSON.toJSONString(newRequest));
        if (entity != null){
            post.setEntity(entity);
            post.removeHeaders("Content-type");
            post.removeHeaders("Accept");
        }
    }

    @Override
    public Object afterResponse(String api, String body) {
        if (body == null || body.trim().length() == 0) return null;
        //{flag:'success'}
        String result = (String) JSON.parseObject(body).get("flag");
        CreditBankCradResponse reps = new CreditBankCradResponse();
        reps.setResponseData(new CreditBankCardBean());
        reps.getResponseData().setIsSuccess("success".equals(result));
        reps.setCookies("");
        reps.setExceptionMessage("");
        return reps;
    }
}
