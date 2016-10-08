package com.vankong.forward.bankcard;

import com.vankong.forward.login.LoginBean;

public class CustomBankCardResponse {
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
