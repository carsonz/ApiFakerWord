package com.vankong.forward.login;

import com.alibaba.fastjson.JSON;
import com.vankong.utils.VKHttpAbstract;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @项目名称：ApiFakerWord
 * @类名称：authenticate
 * @创建人：cailiang
 * @创建时间：16/9/22 15:46
 * @修改人：
 * @修改时间：16/9/22 15:46
 * @修改备注：
 */
public class authenticate extends VKHttpAbstract{
    @Override
    public void preRequest(String api, String param, HttpPost post) {
        if (param == null || param.trim().length() == 0) return;
        LoginRequest lr = JSON.parseObject(param,LoginRequest.class);

        HashMap<String,String> newRequest = new HashMap<String, String>();
        newRequest.put("currentUserId",lr.getLoginID());
        newRequest.put("password",lr.getLoginPwd());
        newRequest.put("isRememberPD","on");
        newRequest.put("isRememberPassword","on");
        newRequest.put("verifyCode","");

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

        String startFlag = "var empId = '";
        int start = body.indexOf(startFlag);
        String empid = "";
        if (start > 0)
        {
            String newResp = body.substring(start);
            empid = newResp.substring(startFlag.length(),newResp.indexOf("';"));
        }

        LoginResponse reps = new LoginResponse();
        reps.setResponseData(new LoginBean());
        reps.getResponseData().setLoginId(empid);
        reps.getResponseData().setIsLoginSuccess(empid.length() > 0?"true":"false");
        reps.setCookies("");
        reps.setExceptionMessage(empid.length()>0?"":"账号或密码错误!");
        return reps;
    }
}
