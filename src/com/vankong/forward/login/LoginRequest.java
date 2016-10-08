package com.vankong.forward.login;

/**
 * @项目名称：ApiFakerWord
 * @类名称：LoginRequest
 * @创建人：cailiang
 * @创建时间：16/9/22 15:52
 * @修改人：
 * @修改时间：16/9/22 15:52
 * @修改备注：
 */
public class LoginRequest {
    private String deviceID;
    private String loginID;
    private String includeEmployeeInfo;
    private String loginPwd;

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getIncludeEmployeeInfo() {
        return includeEmployeeInfo;
    }

    public void setIncludeEmployeeInfo(String includeEmployeeInfo) {
        this.includeEmployeeInfo = includeEmployeeInfo;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }
}
