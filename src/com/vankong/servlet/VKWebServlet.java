package com.vankong.servlet;

import com.alibaba.fastjson.JSON;
import com.vankong.apimanager.VKApiManager;
import com.vankong.domain.VKApiBean;
import com.vankong.domain.VKChangeBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @项目名称：ApiFakerWord
 * @类名称：VKWebServlet
 * @创建人：cailiang
 * @创建时间：16/9/10 18:04
 * @修改人：
 * @修改时间：16/9/10 18:04
 * @修改备注：
 */
public class VKWebServlet extends VKSuperSevlet {

    public void process(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
    {
        String uri = req.getRequestURI();
        processWebApi(uri,req,resp);
    }
    private void processWebApi(String uri,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String api = uri.substring(uri.indexOf("webapi") + 7);
        VKApiManager.getInstance().resetAll();
        String json = readRequestBody(req);
        VKApiBean proj = null;
        if (json.length() > 0){
            proj = JSON.parseObject(json, VKApiBean.class);
        }
        if (api.equals(WebAPI.CONFIG_PATH)) {
            String ret = VKApiManager.getInstance().getConfigPath();
            writeResponse(resp,JSON.toJSONString(new VKResult(true,ret)));
        }else if (api.equals(WebAPI.PROJECT_LIST)) {
            List<VKApiBean> ret = VKApiManager.getInstance().getProjectList();
            writeResponse(resp,JSON.toJSONString(new VKResult(ret)));
        }else if (api.equals(WebAPI.PROJECT_ADD)) {
            boolean ret = VKApiManager.getInstance().addProject(proj);
            returnSimpleResult(resp,ret);
        }else if(api.equals(WebAPI.PROJECT_DEL)) {
            boolean ret = VKApiManager.getInstance().removeProject(proj);
            returnSimpleResult(resp,ret);
        }else if(api.equals(WebAPI.CATEGORY_ADD)) {
            boolean ret = VKApiManager.getInstance().addCategory(proj);
            returnSimpleResult(resp,ret);
        }else if(api.equals(WebAPI.CATEGORY_DEL)) {
            boolean ret = VKApiManager.getInstance().removeCategory(proj);
            returnSimpleResult(resp,ret);
        }else if(api.equals(WebAPI.CATEGORY_UPDATE)) {
            VKChangeBean cg = JSON.parseObject(json, VKChangeBean.class);
            boolean ret = VKApiManager.getInstance().updateProjectCategory(cg);
            returnSimpleResult(resp,ret);
        }else if(api.equals(WebAPI.CATEGORY_LIST)) {
            List<VKApiBean> ret = VKApiManager.getInstance().getCategoryList(proj);
            writeResponse(resp,JSON.toJSONString(new VKResult(ret)));
        }else if(api.equals(WebAPI.API_ADD)) {
            boolean ret = VKApiManager.getInstance().addApi(proj);
            returnSimpleResult(resp,ret);
        }else if(api.equals(WebAPI.API_DEL)) {
            boolean ret = VKApiManager.getInstance().removeApi(proj);
            returnSimpleResult(resp,ret);
        }else if(api.equals(WebAPI.API_UPDATE)) {
           boolean ret = VKApiManager.getInstance().updateApi(proj);
            returnSimpleResult(resp,ret);
        }else if(api.equals(WebAPI.API_LIST)) {
            List<VKApiBean> ret = VKApiManager.getInstance().getApiList(proj);
            writeResponse(resp,JSON.toJSONString(new VKResult(ret)));
        }
    }
}
