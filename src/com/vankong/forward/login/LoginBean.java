package com.vankong.forward.login;

/**
 * @项目名称：ServerBrige
 * @类名称：LoginBean
 * @创建人：cailiang
 * @创建时间：16/3/28 14:28
 * @修改人：
 * @修改时间：16/3/28 14:28
 * @修改备注：
 */
public class LoginBean {
    private String isLoginSuccess;
    private String loginId;

    public String getIsLoginSuccess() {
        return isLoginSuccess;
    }

    public void setIsLoginSuccess(String isLoginSuccess) {
        this.isLoginSuccess = isLoginSuccess;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
}
