package com.vankong.forward.login;

/**
 * @项目名称：ServerBrige
 * @类名称：LoginResponse
 * @创建人：cailiang
 * @创建时间：16/3/28 14:27
 * @修改人：
 * @修改时间：16/3/28 14:27
 * @修改备注：
 */
public class LoginResponse {
    private String exceptionMessage;
    private String cookies;
    private LoginBean responseData;

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getCookies() {
        return cookies;
    }

    public void setCookies(String cookies) {
        this.cookies = cookies;
    }

    public LoginBean getResponseData() {
        return responseData;
    }

    public void setResponseData(LoginBean responseData) {
        this.responseData = responseData;
    }
}
