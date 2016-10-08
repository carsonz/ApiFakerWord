package com.vankong.forward.bankcardsyn;

import java.io.Serializable;;

public class BankInfoBean implements Serializable {

    private Long id;
    private String bankCodeNum;
    private String bankName;
    private Boolean payUse;
    private Boolean decudt;
    private String smsBankName;
    private String thirdPartyPayment;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public BankInfoBean() {
    }

    public BankInfoBean(Long id) {
        this.id = id;
    }

    public BankInfoBean(Long id, String bankCodeNum, String bankName, Boolean payUse, Boolean decudt, String smsBankName, String thirdPartyPayment) {
        this.id = id;
        this.bankCodeNum = bankCodeNum;
        this.bankName = bankName;
        this.payUse = payUse;
        this.decudt = decudt;
        this.smsBankName = smsBankName;
        this.thirdPartyPayment = thirdPartyPayment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankCodeNum() {
        return bankCodeNum;
    }

    public void setBankCodeNum(String bankCodeNum) {
        this.bankCodeNum = bankCodeNum;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Boolean getPayUse() {
        return payUse;
    }

    public void setPayUse(Boolean payUse) {
        this.payUse = payUse;
    }

    public Boolean getDecudt() {
        return decudt;
    }

    public void setDecudt(Boolean decudt) {
        this.decudt = decudt;
    }

    public String getSmsBankName() {
        return smsBankName;
    }

    public void setSmsBankName(String smsBankName) {
        this.smsBankName = smsBankName;
    }

    public String getThirdPartyPayment() {
        return thirdPartyPayment;
    }

    public void setThirdPartyPayment(String thirdPartyPayment) {
        this.thirdPartyPayment = thirdPartyPayment;
    }

    // KEEP METHODS - put your custom methods here

    @Override
    public String toString() {
        return "BankInfoBean{" +
                "id=" + id +
                ", bankCodeNum='" + bankCodeNum + '\'' +
                ", bankName='" + bankName + '\'' +
                ", payUse=" + payUse +
                ", decudt=" + decudt +
                ", smsBankName='" + smsBankName + '\'' +
                ", thirdPartyPayment='" + thirdPartyPayment + '\'' +
                '}';
    }
    // KEEP METHODS END

}
