package com.vankong.forward.bankcardsyn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.vankong.forward.bankcard.CreditBankCardBean;
import com.vankong.forward.bankcard.CreditBankCradResponse;
import com.vankong.forward.login.LoginResponse;
import com.vankong.utils.VKHttpAbstract;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;

import java.util.ArrayList;
import java.util.List;

public class BankCardCodeValueApi extends VKHttpAbstract{
    @Override
    public void preRequest(String api, String param, HttpPost post) {
        HttpEntity entity = jsonToForm(param);
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
        List<BankCardCVBeanCMIS> list = js.parseArray(rows,BankCardCVBeanCMIS.class);
        ArrayList<BankInfoBean> responseData = new ArrayList<BankInfoBean>();
        for(BankCardCVBeanCMIS bc: list){
            BankInfoBean bb = new BankInfoBean();
            bb.setBankCodeNum(bc.getAcc_bank_cde());
            bb.setBankName(bc.getAcc_bank_name());
            responseData.add(bb);
        }
        BankCodeResponse reps = new BankCodeResponse();
        reps.setResponseData(responseData);
        reps.setCookies("");
        reps.setExceptionMessage("");
        return reps;
    }
}
