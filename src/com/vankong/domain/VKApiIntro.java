package com.vankong.domain;

/**
 * @项目名称：ApiFakerWord
 * @类名称：VKApiIntro
 * @创建人：cailiang
 * @创建时间：16/9/16 10:37
 * @修改人：
 * @修改时间：16/9/16 10:37
 * @修改备注：
 */
public class VKApiIntro {
    private int level;
    private String name;   //字段名称
    private String intro;  //字段说明

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
