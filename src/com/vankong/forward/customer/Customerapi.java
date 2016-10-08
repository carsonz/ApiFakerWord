package com.vankong.forward.customer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.vankong.utils.VKHttpAbstract;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Customerapi extends VKHttpAbstract {
    @Override
    public void preRequest(String api, String param, HttpPost post) {
        if (param == null || param.trim().length() == 0) return;
        CustomerSyncRequest request = JSON.parseObject(param,CustomerSyncRequest.class);
        String empid = (String) JSON.parseObject(param).get("EMP_SID");
        HashMap<String,String> newRequest = new HashMap<String, String>();

        newRequest.put("equals.cust_loid",request.getEmployeeID());
        newRequest.put("page","1");
        newRequest.put("rows",request.getRecordsetQuantity());
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
        List<CustInfo> list = js.parseArray(rows,CustInfo.class);
        ArrayList<CustomerBean> responseData = new ArrayList<CustomerBean>();
        for(CustInfo bc: list){
            CustomerBean bb = new CustomerBean();
            bb.setAge(bc.getCust_age());
            bb.setCustomerName(bc.getCust_name());
            bb.setMobile(bc.getIndiv_mobile());
            bb.setEmployeeID(bc.getCust_loid());
            bb.setBranchID(bc.getCust_bch());
            bb.setVillageID(bc.getCust_village());
            responseData.add(bb);
        }
        CustomerSyncResponse reps = new CustomerSyncResponse();
        reps.setResponseData(responseData);
        reps.setCookies("");
        reps.setExceptionMessage("");
        return reps;
    }
}
