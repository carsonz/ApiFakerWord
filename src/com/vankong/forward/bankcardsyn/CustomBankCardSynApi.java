package com.vankong.forward.bankcardsyn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.vankong.forward.login.LoginRequest;
import com.vankong.forward.login.LoginResponse;
import com.vankong.utils.VKHttpAbstract;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomBankCardSynApi extends VKHttpAbstract{
    @Override
    public void preRequest(String api, String param, HttpPost post) {
        if (param == null || param.trim().length() == 0) return;
        QueryBankCardByClientIDRequest qbcr = JSON.parseObject(param,QueryBankCardByClientIDRequest.class);
        String empid = (String) JSON.parseObject(param).get("EMP_SID");
        HashMap<String,String> newRequest = new HashMap<String, String>();
        newRequest.put("cust_id",qbcr.getClientID());
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
        JSONArray js = JSON.parseObject(body).getJSONArray("rows");
        String rows = js.toJSONString();
        List<CustomBankCardSynBeanCMIS> list = js.parseArray(rows,CustomBankCardSynBeanCMIS.class);
        ArrayList<BankCardBean> responseData = new ArrayList<BankCardBean>();
        for(CustomBankCardSynBeanCMIS bc: list){
            BankCardBean bb = new BankCardBean();
            bb.setCardNO(bc.getCard_no());
            bb.setCity(bc.getBank_city());
            bb.setPrivince(bc.getBank_privince());
            bb.setClientID(bc.getCust_id());
            bb.setHolderName(bc.getCust_name());
            bb.setId(bc.getCust_cardid());
            responseData.add(bb);
        }
        QueryCustomerBankResponse reps = new QueryCustomerBankResponse();
        reps.setResponseData(responseData);
        reps.setCookies("");
        reps.setExceptionMessage("");
        return reps;
    }
}
