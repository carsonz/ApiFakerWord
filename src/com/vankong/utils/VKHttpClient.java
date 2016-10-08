package com.vankong.utils;

import com.alibaba.fastjson.JSON;
import com.vankong.servlet.VKResult;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @项目名称：ServerBrige
 * @类名称：VKHttpClient
 * @创建人：cailiang
 * @创建时间：16/3/28 11:49
 * @修改人：
 * @修改时间：16/3/28 11:49
 * @修改备注：
 */
public class VKHttpClient {
    private HttpClient httpClient = null;
    private long startTime = 0L;
    private long endTime = 0L;
    public VKHttpClient()
    {
        httpClient = new DefaultHttpClient();
    }

    public VKResult postJson(String api, String parameters, String cookie, VKHttpAbstract dele) {
        VKResult ret = new VKResult();
        String body = null;
        if (!api.startsWith("http")){
            api = "http://" + api;
        }
        HttpPost method = new HttpPost(api);
        if (method == null) return null;

        method.addHeader("Content-type", "application/json; charset=utf-8");
        method.setHeader("Accept", "application/json");

        if (parameters != null) {
            method.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));
        }
        if (cookie != null && cookie.trim().length() > 0)
        {
            method.setHeader("Cookie", cookie);
        }
        if (dele != null){
            try {
                dele.preRequest(api,parameters,method);
            }catch (Exception e){}
        }

        try {
            startTime = System.currentTimeMillis();
            HttpResponse response = httpClient.execute(method);
            endTime = System.currentTimeMillis();

            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("调用API 花费时间(单位：毫秒)：" + (endTime - startTime));

            body = EntityUtils.toString(response.getEntity(),"utf-8");

            if (statusCode != HttpStatus.SC_OK) {
                body = "" + response.toString();
            }
            ret.setErrCode("" + statusCode);
            if (dele != null){
                try {
                    Object newResp = dele.afterResponse(api,body);
                    if (newResp != null) body = JSON.toJSONString(newResp);
                }catch (Exception e){}
            }

        } catch (IOException e) {
            body = e.getMessage();
            ret.setErrCode("-1");
            e.printStackTrace();
        }
        ret.setErrMsg(body);
        return ret;
    }

    public VKResult postJson(String api, String parameters,VKHttpAbstract dele) {
        return postJson(api,parameters,null,dele);
    }
        /**
         * 调用 API
         *
         * @param parameters
         * @return
         */
    public VKResult postJson(String api, String parameters) {
        return postJson(api,parameters,null);
    }
}
