package com.vankong.servlet;

import com.alibaba.fastjson.JSON;
import com.vankong.apimanager.VKApiManager;
import com.vankong.domain.VKApiBean;
import com.vankong.forward.VKForwardManager;
import com.vankong.utils.VKHttpAbstract;
import com.vankong.utils.VKHttpClient;
import org.apache.http.HttpResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @项目名称：ApiFakerWord
 * @类名称：VKHookServlet
 * @创建人：cailiang
 * @创建时间：16/9/8 00:32
 * @修改人：
 * @修改时间：16/9/8 00:32
 * @修改备注：
 */
public class VKHookServlet extends VKSuperSevlet{

    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String uri = req.getRequestURI();
        String realUri = uri.substring(uri.indexOf("faker/") + 6);
        VKApiManager.getInstance().resetAll();
        VKApiBean apiBean = VKApiManager.getInstance().getApi(realUri);
        if (apiBean != null){
            switch (apiBean.getApiState()){
                case 0:
                    //返回模拟数据
                    writeResponse(resp,apiBean.getResponseJson());
                    return;
                case 1:
                    //返回请求结果
                    forwardApi(req,resp,apiBean);
                    return;
            }
        }
        returnJsp("/err.jsp").forward(req,resp);
        return;
    }

    private RequestDispatcher returnJsp(String jsp)
    {
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/err.jsp"); //定向的页面
        return rd;
    }
    private void forwardApi(HttpServletRequest req,HttpServletResponse resp,VKApiBean apiBean)
    {
        String api = apiBean.getForwardUrl();
        VKHttpAbstract del = VKForwardManager.getManager().getApiHook(api);  //根据转发地址获取相对应的处理类
        String headerc = req.getHeader("Cookie");
        if (headerc == null){
            headerc = req.getHeader("Cookies");
        }
        VKResult rep = new VKHttpClient().postJson(apiBean.getForwardUrl(),readRequestBody(req),headerc,del);  //网络请求
        System.out.println("resp:" + rep.getErrCode() + "\napibean:" + JSON.toJSONString(apiBean));
        if (!"200".equals(rep.getErrCode())){
            writeObject(resp,rep);
        }else{
            writeResponse(resp,rep.getErrMsg());
        }
    }
}
