package com.vankong.apimanager;

import com.alibaba.fastjson.JSON;
import com.vankong.domain.VKApiBean;
import com.vankong.domain.VKChangeBean;
import com.vankong.utils.PinYin2Abbreviation;
import com.vankong.utils.Utils;

import java.io.File;
import java.text.Collator;
import java.util.*;

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

    private ArrayList<VKApiBean> mApiList = new ArrayList<VKApiBean>();  //所有对象集合 用来遍历
    private HashMap<String,VKApiBean> mApiUrlMap = new HashMap<String, VKApiBean>();  //接口集合
    private HashMap<String,VKApiBean> mProjectKeyList = new HashMap<String, VKApiBean>();  //项目集合
    private HashMap<String,HashMap<String,VKApiBean>> mCategoryKeyList = new HashMap<String, HashMap<String, VKApiBean>>(); //分类集合
    private HashMap<String,List<VKApiBean>> mApiKeyMap = new HashMap<String, List<VKApiBean>>();    //同类接口集合


    public String getRootPath()
    {
        String currentPath = getClass().getResource("/").getPath();
        String webContent = currentPath.substring(0,currentPath.lastIndexOf("WEB-INF") - 1);
        int last2Index = webContent.lastIndexOf("/",webContent.lastIndexOf("/") - 1);
        String ret = webContent.substring(0,last2Index) +  "/.ApiFakerWord/";
        return  ret;
    }
    public String getConfigPath()
    {
        return getRootPath() + CONFIG_FILE;
    }
    public synchronized void resetAll()
    {
        mApiList.clear();
        mApiKeyMap.clear();
        mApiUrlMap.clear();
        mCategoryKeyList.clear();
        mProjectKeyList.clear();

        String json = Utils.readFile(getConfigPath());
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
        Collections.sort(list, new Comparator<VKApiBean>() {
            @Override
            public int compare(VKApiBean o1, VKApiBean o2) {
                return (PinYin2Abbreviation.cn2py(o1.getProjectName()).compareTo(PinYin2Abbreviation.cn2py(o2.getProjectName())));// > ?1:0);
            }
        });
        return list;
    }
    public List<VKApiBean> getCategoryList(VKApiBean p)
    {
        resetAll();
        ArrayList<VKApiBean> list = new ArrayList<VKApiBean>();
        HashMap<String,VKApiBean> cateMap = mCategoryKeyList.get(p.getProjectName());
        if (cateMap != null){
            list.addAll(cateMap.values());
            Collections.sort(list, new Comparator<VKApiBean>() {
                @Override
                public int compare(VKApiBean o1, VKApiBean o2) {
                    return (PinYin2Abbreviation.cn2py(o1.getCategoryName()).compareTo(PinYin2Abbreviation.cn2py(o2.getCategoryName())));// > ?1:0);
                }
            });
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

    public synchronized VKApiBean getApi(String api)
    {
        return mApiUrlMap.get(api);
    }

    public synchronized boolean removeProject(VKApiBean proj)
    {
        List<VKApiBean> removes = new ArrayList<VKApiBean>();
        for (VKApiBean b : mApiList) {
            if (proj.getProjectName().equals(b.getProjectName()))
            {
                removes.add(b);
            }
        }
        mApiList.removeAll(removes);
        return saveToFile();
    }
    public synchronized boolean removeCategory(VKApiBean cate)
    {
        List<VKApiBean> removes = new ArrayList<VKApiBean>();
        for (VKApiBean b : mApiList) {
            if (cate.getProjectName().equals(b.getProjectName()) && cate.getCategoryName().equals(b.getCategoryName()))
            {
                removes.add(b);
            }
        }
        mApiList.removeAll(removes);
        return saveToFile();
    }
    public synchronized boolean updateProjectCategory(VKChangeBean cate)
    {
        for (VKApiBean b : mApiList) {
            if (cate.getProjectName().equals(b.getProjectName())) {
                //修改分类
                if (cate.getCategoryName() != null && cate.getCategoryName().trim().length() > 0) {
                    if (cate.getCategoryName().equals(b.getCategoryName())){
                        b.setProjectName(cate.getProjectNewName());
                        b.setCategoryName(cate.getCategoryNewName());
                    }
                }else {
                    //修改项目名称
                    b.setProjectName(cate.getProjectNewName());
                }
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
