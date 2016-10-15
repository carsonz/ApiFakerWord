package com.vankong.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @项目名称：ApiFakerWord
 * @类名称：VKApiBean
 * @创建人：cailiang
 * @创建时间：16/9/8 21:23
 * @修改人：
 * @修改时间：16/9/8 21:23
 * @修改备注：
 */
public class VKApiBean {
    private String apiId;   //apiID
    private String apiName;  //api名称

    private String categoryName;    //所属分类名称
    private String projectName;     //所属项目名称

    private String url;             //自身url路径
    private String forwardUrl;      //目标.do的url路径

    private ArrayList<String> imageList;
    private int apiState;     //转发(0)  还是模拟(1)

    private String requestJson;    //request模拟数据
    private HashMap<String,String> requestMap;
    private List<VKApiIntro> requestIntroMap;   //模拟请求数据 字段说明

    private String responseJson;     //response模拟数据
    private HashMap<String,String> responseMap;
    private List<VKApiIntro> responseIntroMap;   //模拟返回数据 字段说明

    public VKApiBean()
    {

    }
    public VKApiBean(String pname,String cname)
    {
        setProjectName(pname);
        setCategoryName(cname);
    }

    public VKApiBean(String pname)
    {
        setProjectName(pname);
    }

    /**
     * 地址
     */
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 真实地址
     */
    public String getForwardUrl() {
        return forwardUrl;
    }

    public void setForwardUrl(String forwardUrl) {
        this.forwardUrl = forwardUrl;
    }

    /**
     * 图片名称列表
     */
    public ArrayList<String> getImageList() {
        return imageList;
    }

    public void setImageList(ArrayList<String> imageList) {
        this.imageList = imageList;
    }

    /**
     * 接口状态
     */
    public int getApiState() {
        return apiState;
    }

    public void setApiState(int apiState) {
        this.apiState = apiState;
    }

    /**
     * 请求参数
     */
    public String getRequestJson() {
        return requestJson;
    }

    public void setRequestJson(String requestJson) {
        this.requestJson = requestJson;
    }

    /**
     * 请求参数
     */
    public HashMap<String, String> getRequestMap() {
        return requestMap;
    }

    public void setRequestMap(HashMap<String, String> requestMap) {
        this.requestMap = requestMap;
    }

    /**
     * 请求参数说明
     */
    public List<VKApiIntro> getRequestIntroMap() {
        return requestIntroMap;
    }

    public void setRequestIntroMap(List<VKApiIntro> requestIntroMap) {
        this.requestIntroMap = requestIntroMap;
    }

    /**
     * 返回模拟数据
     */
    public String getResponseJson() {
        return responseJson;
    }

    public void setResponseJson(String responseJson) {
        this.responseJson = responseJson;
    }

    /**
     * 返回参数
     */
    public HashMap<String, String> getResponseMap() {
        return responseMap;
    }

    public void setResponseMap(HashMap<String, String> responseMap) {
        this.responseMap = responseMap;
    }

    /**
     * 返回参数说明
     */
    public List<VKApiIntro> getResponseIntroMap() {
        return responseIntroMap;
    }

    public void setResponseIntroMap(List<VKApiIntro> responseIntroMap) {
        this.responseIntroMap = responseIntroMap;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    /**
     * 分类名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

}
