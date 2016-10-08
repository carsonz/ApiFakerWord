package com.vankong.apimanager;

import com.alibaba.fastjson.JSON;
import com.vankong.domain.VKApiBean;
import com.vankong.utils.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @项目名称：ApiFakerWord
 * @类名称：VKApiManager
 * @创建人：cailiang
 * @创建时间：16/9/8 21:23
 * @修改人：
 * @修改时间：16/9/8 21:23
 * @修改备注：
 */
public class VKApiManager {
    private static VKApiManager mApiManager = null;
    public static VKApiManager getInstance()
    {
        if (mApiManager == null){
            mApiManager = new VKApiManager();
            mApiManager.resetAll();
        }
        return mApiManager;
    }
    public final static String CONFIG_FILE = "config/config.json";

    private ArrayList<VKApiBean> mApiList = new ArrayList<VKApiBean>();
    private HashMap<String,VKApiBean> mApiUrlMap = new HashMap<String, VKApiBean>();
    private HashMap<String,VKApiBean> mProjectKeyList = new HashMap<String, VKApiBean>();
    private HashMap<String,HashMap<String,VKApiBean>> mCategoryKeyList = new HashMap<String, HashMap<String, VKApiBean>>();
    private HashMap<String,List<VKApiBean>> mApiKeyMap = new HashMap<String, List<VKApiBean>>();


    public String getRootPath()
    {
        return System.getProperty("user.home") + "/.ApiFakerWord/";
//        String system = System.getProperty("os.name");
//        if (system.contains("windows")){
//            String all = Thread.currentThread().getContextClassLoader().getResource("").toString();
//            String unHead = all.substring(all.indexOf("file:") + 5);
//            String ret = unHead.substring(0,unHead.indexOf("WEB-INF") + 8);
//            return ret;
//        }else{
//            return "~/.ApiFakerWord/";
//        }
    }

//    public String getRootPath()
//    {

//    }
    public synchronized void resetAll()
    {
        mApiList.clear();
        mApiKeyMap.clear();
        mApiUrlMap.clear();
        mCategoryKeyList.clear();
        mProjectKeyList.clear();

        String json = Utils.readFile(getRootPath() + CONFIG_FILE);
        if (!json.isEmpty()) {
            List<VKApiBean> configs = JSON.parseArray(json, VKApiBean.class);
            mApiList.addAll(configs);
            sortApi(mApiList);
        }
        //if (mApiList.isEmpty()) addDemo();
    }
    public List<VKApiBean> getProjectList()
    {
        List<VKApiBean> list = new ArrayList<VKApiBean>();
        list.addAll(mProjectKeyList.values());
        return list;
    }
    public List<VKApiBean> getCategoryList(VKApiBean p)
    {
        resetAll();
        ArrayList<VKApiBean> list = new ArrayList<VKApiBean>();
        HashMap<String,VKApiBean> cateMap = mCategoryKeyList.get(p.getProjectName());
        if (cateMap != null){
            list.addAll(cateMap.values());
        }
        return list;
    }
    public List<VKApiBean> getApiList(VKApiBean p)
    {
        resetAll();
        ArrayList<VKApiBean> list = new ArrayList<VKApiBean>();
        String key = p.getProjectName() + "_" + p.getCategoryName();
        List<VKApiBean> temp = mApiKeyMap.get(key);
        if (temp != null && temp.size() > 0){
            list.addAll(temp);
        }
        return list;
    }
    private void sortApi(List<VKApiBean> apis)
    {
        for (VKApiBean b : apis) {
            String projName = b.getProjectName();
            String cateName = b.getCategoryName();
            String apiName = b.getApiName();

            //初始化项目
            {
                VKApiBean proj = mProjectKeyList.get(projName);
                if (proj == null) {
                    proj = new VKApiBean(projName);
                }
                mProjectKeyList.put(projName, proj);
            }

            HashMap<String, VKApiBean> categoryMap = mCategoryKeyList.get(projName);
            if (categoryMap == null) {
                categoryMap = new HashMap<String, VKApiBean>();
                mCategoryKeyList.put(projName, categoryMap);
            }

            //初始化分类
            if(cateName != null && cateName.length() > 0){
                VKApiBean category = categoryMap.get(cateName);
                if (category == null) {
                    category = new VKApiBean(projName , cateName);
                }
                categoryMap.put(cateName, category);
                mCategoryKeyList.put(projName, categoryMap);

                String key = projName + "_" + cateName;
                List<VKApiBean> list = mApiKeyMap.get(key);
                if (list == null){
                    list = new ArrayList<VKApiBean>();
                    mApiKeyMap.put(key,list);
                }

                if (apiName != null && apiName.length() > 0){
                    list.add(b);
                    mApiKeyMap.put(key,list);
                    mApiUrlMap.put(b.getUrl(), b);
                }
            }
        }
    }
    private void addDemo()
    {
        VKApiBean p = new VKApiBean("产品名称","分类名称");
        p.setApiId("1");
        p.setApiName("Api名称");
        addApi(p);
        p.setUrl("/user/login");
    }

    public VKApiBean getApi(String api)
    {
        return mApiUrlMap.get(api);
    }

    public synchronized boolean removeProject(VKApiBean proj)
    {
        for (VKApiBean b : mApiList) {
            if (proj.getProjectName().equals(b.getProjectName()))
            {
                mApiList.remove(b);
                break;
            }
        }
        return saveToFile();
    }
    public synchronized boolean removeCategory(VKApiBean cate)
    {
        for (VKApiBean b : mApiList) {
            if (cate.getProjectName().equals(b.getProjectName()) && cate.getCategoryName().equals(b.getCategoryName()))
            {
                mApiList.remove(b);
                break;
            }
        }
        return saveToFile();
    }
    public synchronized boolean removeApi(VKApiBean api)
    {
        if (api.getApiId() == null || api.getApiId().length() == 0){
            return true;
        }
        for (VKApiBean b : mApiList){
            if (api.getApiId().equals(b.getApiId()))
            {
                mApiList.remove(b);
                break;
            }
        }
        return saveToFile();
    }
    public synchronized boolean addProject(VKApiBean proj)
    {
        if (mProjectKeyList.containsKey(proj.getProjectName())){
            return false;
        }
        return addApi(proj);
    }

    public synchronized boolean addCategory(VKApiBean proj)
    {
        if (!mProjectKeyList.containsKey(proj.getProjectName())){
            return false;
        }
        if (mCategoryKeyList.get(proj.getProjectName()).containsKey(proj.getCategoryName()))
        {
            return false;
        }
        return addApi(proj);
    }

    public synchronized boolean addApi(VKApiBean proj)
    {
        String url = proj.getUrl();
        if (url != null && url.length() > 0 && mApiUrlMap.containsKey(url)) {
            return false;
        }
        if (proj.getApiName() != null)
        {
            long millions = System.currentTimeMillis();
            proj.setApiId("" + millions);
        }
        mApiList.add(proj);
        return saveToFile();
    }
    public boolean updateApi(VKApiBean proj) {
        if (proj.getApiId() == null || proj.getApiId().length() == 0){
            return false;
        }
        for (VKApiBean b : mApiList){
            if (proj.getApiId().equals(b.getApiId()))
            {
                int old = mApiList.indexOf(b);
                mApiList.remove(old);
                mApiList.add(old,proj);
                break;
            }
        }
        return saveToFile();
    }
    private boolean saveToFile()
    {
        String json = JSON.toJSONString(mApiList);
        return Utils.writeFile(getRootPath() + CONFIG_FILE,json);
    }
}
