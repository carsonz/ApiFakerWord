package com.vankong.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @项目名称：ApiFakerWord
 * @类名称：VKHttpAbstract
 * @创建人：cailiang
 * @创建时间：16/9/22 15:41
 * @修改人：
 * @修改时间：16/9/22 15:41
 * @修改备注：
 */
public abstract class VKHttpAbstract {
    public abstract void preRequest(String api, String param,HttpPost post);
    public abstract Object afterResponse(String api, String body);
    public HttpEntity jsonToForm(String params)
    {
        HttpEntity entity = null;
        if (params == null || params.trim().length() == 0){
            return entity;
        }
        try {
            JSONObject obj = JSON.parseObject(params);
            Iterator<String> it = obj.keySet().iterator();
            List<NameValuePair> values = new ArrayList<NameValuePair>();

            while (it.hasNext()){
                String key = it.next();
                String b = "" + obj.get(key);
                BasicNameValuePair base = new BasicNameValuePair(key,b);
                values.add(base);
            }
            entity = new UrlEncodedFormEntity(values,"utf-8");
        }catch (Exception e){

        }
        return entity;
    }
}
