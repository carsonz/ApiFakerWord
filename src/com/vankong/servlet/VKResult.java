package com.vankong.servlet;

import com.vankong.domain.VKApiBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @项目名称：ApiFakerWord
 * @类名称：VKResult
 * @创建人：cailiang
 * @创建时间：16/9/11 00:11
 * @修改人：
 * @修改时间：16/9/11 00:11
 * @修改备注：
 */
public class VKResult {
    private String errCode;
    private String errMsg;
    private List<Object> result = new ArrayList<Object>();
    public VKResult(boolean success,String retMsg)
    {
        if (success){
            errCode = "" + 0;
        }else{
            errCode = "" + -1;
        }
        errMsg = retMsg;
    }
    public VKResult()
    {

    }

    public VKResult(List<VKApiBean>ret)
    {
        errCode = "" + 0;
        errMsg = "";
        result.addAll(ret);
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public List<Object> getResult() {
        return result;
    }

    public void setResult(List<Object> result) {
        this.result = result;
    }
}
