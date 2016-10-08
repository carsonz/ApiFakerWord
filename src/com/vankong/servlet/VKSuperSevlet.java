package com.vankong.servlet;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @项目名称：ApiFakerWord
 * @类名称：VKSuperSevlet
 * @创建人：cailiang
 * @创建时间：16/9/10 18:05
 * @修改人：
 * @修改时间：16/9/10 18:05
 * @修改备注：
 */
public abstract class VKSuperSevlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json;charset=utf-8");
            process(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json;charset=utf-8");
            process(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }
    protected void writeObject(HttpServletResponse resp , Object json)
    {
        try {
            String value =JSON.toJSONString(json);
            PrintWriter pw = resp.getWriter();
            pw.println(value);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void writeResponse(HttpServletResponse resp , String json)
    {
        try {
            PrintWriter pw = resp.getWriter();
            pw.println(json);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected String readRequestBody(HttpServletRequest req)
    {
        StringBuffer sb = new StringBuffer("");
        try {
            String ret = null;
            BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream(),"utf-8"));
            while((ret = br.readLine()) != null) {
                sb.append(ret);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    protected void returnSimpleResult(HttpServletResponse resp,boolean yes)
    {
        writeResponse(resp, JSON.toJSONString(new VKResult(yes,"")));
    }

    public abstract void process(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException;
}
