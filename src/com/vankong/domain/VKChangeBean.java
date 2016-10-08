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
public class VKChangeBean {

    private String categoryName;
    private String categoryNewName;

    private String projectName;
    private String projectNewName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryNewName() {
        return categoryNewName;
    }

    public void setCategoryNewName(String categoryNewName) {
        this.categoryNewName = categoryNewName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectNewName() {
        return projectNewName;
    }

    public void setProjectNewName(String projectNewName) {
        this.projectNewName = projectNewName;
    }
}
