package com.vankong.forward.login;

public class LoginBeanForCMIS {
    private String currentUserId;
    private String password;
    private String verifyCode;
    private String isRememberPD;
    private String isRememberPassword;

    public String getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(String currentUserId) {
        this.currentUserId = currentUserId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getIsRememberPD() {
        return isRememberPD;
    }

    public void setIsRememberPD(String isRememberPD) {
        this.isRememberPD = isRememberPD;
    }

    public String getIsRememberPassword() {
        return isRememberPassword;
    }

    public void setIsRememberPassword(String isRememberPassword) {
        this.isRememberPassword = isRememberPassword;
    }
}
