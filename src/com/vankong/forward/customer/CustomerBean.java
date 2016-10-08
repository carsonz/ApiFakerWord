package com.vankong.forward.customer;

import com.vankong.forward.bankcardsyn.BankCardBean;

import java.io.Serializable;;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
import java.util.ArrayList;;
// KEEP INCLUDES END
/**
 * Entity mapped to table "CUSTOMER_BEAN".
 */
public class CustomerBean implements Serializable {

    private String customerID;
    /** Not-null value. */
    private String customerName;
    /** Not-null value. */
    private String branchName;
    /** Not-null value. */
    private String branchID;
    /** Not-null value. */
    private String centerName;
    /** Not-null value. */
    private String centerID;
    /** Not-null value. */
    private String employeeID;
    /** Not-null value. */
    private String employeeName;
    private String gender;
    private String genderID;
    private String ethnic;
    private String ethnicID;
    private String birthday;
    private String identityCardType;
    private String identityCardNo;
    private String familyPopulation;
    private String labourForcePopulation;
    private String education;
    private String educationID;
    private String marriage;
    private String marriageID;
    private String spouseName;
    private String spousePhone;
    private String spouseIdentityCardNo;
    private String telephone;
    private String mobile;
    private String address;
    private String address2;
    private String householdType;
    private String householdAddress;
    private String residentType;
    private String residentTypeID;
    private String village;
    private String villageID;
    private String streetID;
    private String street;
    private String createTime;
    private String updateTime;
    private String groupID;
    private String age;
    private String identityCardTypeID;
    private String editflag;
    private String isDelete;
    private String latitude;
    private String longitude;
    private String distance;
    private String customerStatus;
    private String syncFailReason;
    private String abbr;
    private String clientLevel;
    private String idCardAddress;
    private String idCardAwardOrg;
    private String idCardEffectivePeriodBegin;
    private String idCardEffectivePeriodEnd;
    /**
     * 客户贫困类型ID
     */
    private Integer NaturePoor;
    /**
     * 客户贫困类型
     */
    private String NaturePoorValue;

    // KEEP FIELDS - put your custom fields here
    private ArrayList<BankCardBean> bankCardList;// 银行卡集合

    /**
     * @return the bankCardList
     */
    public ArrayList<BankCardBean> getBankCardList() {
        return bankCardList;
    }

    /**
     * @param bankCardList
     *            the bankCardList to set
     */
    public void setBankCardList(ArrayList<BankCardBean> bankCardList) {
        this.bankCardList = bankCardList;
    }
    // KEEP FIELDS END

    public CustomerBean() {
    }

    public CustomerBean(String customerID) {
        this.customerID = customerID;
    }

    public CustomerBean(String customerID, String customerName, String branchName, String branchID, String centerName, String centerID, String employeeID, String employeeName, String gender, String genderID, String ethnic, String ethnicID, String birthday, String identityCardType, String identityCardNo, String familyPopulation, String labourForcePopulation, String education, String educationID, String marriage, String marriageID, String spouseName, String spousePhone, String spouseIdentityCardNo, String telephone, String mobile, String address, String address2, String householdType, String householdAddress, String residentType, String residentTypeID, String village, String villageID, String streetID, String street, String createTime, String updateTime, String groupID, String age, String identityCardTypeID, String editflag, String isDelete, String latitude, String longitude, String distance, String customerStatus, String syncFailReason, String abbr, String clientLevel, String idCardAddress, String idCardAwardOrg, String idCardEffectivePeriodBegin, String idCardEffectivePeriodEnd, Integer NaturePoor, String NaturePoorValue) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.branchName = branchName;
        this.branchID = branchID;
        this.centerName = centerName;
        this.centerID = centerID;
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.gender = gender;
        this.genderID = genderID;
        this.ethnic = ethnic;
        this.ethnicID = ethnicID;
        this.birthday = birthday;
        this.identityCardType = identityCardType;
        this.identityCardNo = identityCardNo;
        this.familyPopulation = familyPopulation;
        this.labourForcePopulation = labourForcePopulation;
        this.education = education;
        this.educationID = educationID;
        this.marriage = marriage;
        this.marriageID = marriageID;
        this.spouseName = spouseName;
        this.spousePhone = spousePhone;
        this.spouseIdentityCardNo = spouseIdentityCardNo;
        this.telephone = telephone;
        this.mobile = mobile;
        this.address = address;
        this.address2 = address2;
        this.householdType = householdType;
        this.householdAddress = householdAddress;
        this.residentType = residentType;
        this.residentTypeID = residentTypeID;
        this.village = village;
        this.villageID = villageID;
        this.streetID = streetID;
        this.street = street;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.groupID = groupID;
        this.age = age;
        this.identityCardTypeID = identityCardTypeID;
        this.editflag = editflag;
        this.isDelete = isDelete;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distance = distance;
        this.customerStatus = customerStatus;
        this.syncFailReason = syncFailReason;
        this.abbr = abbr;
        this.clientLevel = clientLevel;
        this.idCardAddress = idCardAddress;
        this.idCardAwardOrg = idCardAwardOrg;
        this.idCardEffectivePeriodBegin = idCardEffectivePeriodBegin;
        this.idCardEffectivePeriodEnd = idCardEffectivePeriodEnd;
        this.NaturePoor = NaturePoor;
        this.NaturePoorValue = NaturePoorValue;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    /** Not-null value. */
    public String getCustomerName() {
        return customerName;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /** Not-null value. */
    public String getBranchName() {
        return branchName;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    /** Not-null value. */
    public String getBranchID() {
        return branchID;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setBranchID(String branchID) {
        this.branchID = branchID;
    }

    /** Not-null value. */
    public String getCenterName() {
        return centerName;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    /** Not-null value. */
    public String getCenterID() {
        return centerID;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setCenterID(String centerID) {
        this.centerID = centerID;
    }

    /** Not-null value. */
    public String getEmployeeID() {
        return employeeID;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    /** Not-null value. */
    public String getEmployeeName() {
        return employeeName;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGenderID() {
        return genderID;
    }

    public void setGenderID(String genderID) {
        this.genderID = genderID;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public String getEthnicID() {
        return ethnicID;
    }

    public void setEthnicID(String ethnicID) {
        this.ethnicID = ethnicID;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdentityCardType() {
        return identityCardType;
    }

    public void setIdentityCardType(String identityCardType) {
        this.identityCardType = identityCardType;
    }

    public String getIdentityCardNo() {
        return identityCardNo;
    }

    public void setIdentityCardNo(String identityCardNo) {
        this.identityCardNo = identityCardNo;
    }

    public String getFamilyPopulation() {
        return familyPopulation;
    }

    public void setFamilyPopulation(String familyPopulation) {
        this.familyPopulation = familyPopulation;
    }

    public String getLabourForcePopulation() {
        return labourForcePopulation;
    }

    public void setLabourForcePopulation(String labourForcePopulation) {
        this.labourForcePopulation = labourForcePopulation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEducationID() {
        return educationID;
    }

    public void setEducationID(String educationID) {
        this.educationID = educationID;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getMarriageID() {
        return marriageID;
    }

    public void setMarriageID(String marriageID) {
        this.marriageID = marriageID;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getSpousePhone() {
        return spousePhone;
    }

    public void setSpousePhone(String spousePhone) {
        this.spousePhone = spousePhone;
    }

    public String getSpouseIdentityCardNo() {
        return spouseIdentityCardNo;
    }

    public void setSpouseIdentityCardNo(String spouseIdentityCardNo) {
        this.spouseIdentityCardNo = spouseIdentityCardNo;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getHouseholdType() {
        return householdType;
    }

    public void setHouseholdType(String householdType) {
        this.householdType = householdType;
    }

    public String getHouseholdAddress() {
        return householdAddress;
    }

    public void setHouseholdAddress(String householdAddress) {
        this.householdAddress = householdAddress;
    }

    public String getResidentType() {
        return residentType;
    }

    public void setResidentType(String residentType) {
        this.residentType = residentType;
    }

    public String getResidentTypeID() {
        return residentTypeID;
    }

    public void setResidentTypeID(String residentTypeID) {
        this.residentTypeID = residentTypeID;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getVillageID() {
        return villageID;
    }

    public void setVillageID(String villageID) {
        this.villageID = villageID;
    }

    public String getStreetID() {
        return streetID;
    }

    public void setStreetID(String streetID) {
        this.streetID = streetID;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIdentityCardTypeID() {
        return identityCardTypeID;
    }

    public void setIdentityCardTypeID(String identityCardTypeID) {
        this.identityCardTypeID = identityCardTypeID;
    }

    public String getEditflag() {
        return editflag;
    }

    public void setEditflag(String editflag) {
        this.editflag = editflag;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getSyncFailReason() {
        return syncFailReason;
    }

    public void setSyncFailReason(String syncFailReason) {
        this.syncFailReason = syncFailReason;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getClientLevel() {
        return clientLevel;
    }

    public void setClientLevel(String clientLevel) {
        this.clientLevel = clientLevel;
    }

    public String getIdCardAddress() {
        return idCardAddress;
    }

    public void setIdCardAddress(String idCardAddress) {
        this.idCardAddress = idCardAddress;
    }

    public String getIdCardAwardOrg() {
        return idCardAwardOrg;
    }

    public void setIdCardAwardOrg(String idCardAwardOrg) {
        this.idCardAwardOrg = idCardAwardOrg;
    }

    public String getIdCardEffectivePeriodBegin() {
        return idCardEffectivePeriodBegin;
    }

    public void setIdCardEffectivePeriodBegin(String idCardEffectivePeriodBegin) {
        this.idCardEffectivePeriodBegin = idCardEffectivePeriodBegin;
    }

    public String getIdCardEffectivePeriodEnd() {
        return idCardEffectivePeriodEnd;
    }

    public void setIdCardEffectivePeriodEnd(String idCardEffectivePeriodEnd) {
        this.idCardEffectivePeriodEnd = idCardEffectivePeriodEnd;
    }

    public Integer getNaturePoor() {
        return NaturePoor;
    }

    public void setNaturePoor(Integer NaturePoor) {
        this.NaturePoor = NaturePoor;
    }

    public String getNaturePoorValue() {
        return NaturePoorValue;
    }

    public void setNaturePoorValue(String NaturePoorValue) {
        this.NaturePoorValue = NaturePoorValue;
    }

    // KEEP METHODS - put your custom methods here

    @Override
    public String toString() {
        return "CustomerBean{" +
                "customerID='" + customerID + '\'' +
                ", customerName='" + customerName + '\'' +
                ", branchName='" + branchName + '\'' +
                ", branchID='" + branchID + '\'' +
                ", centerName='" + centerName + '\'' +
                ", centerID='" + centerID + '\'' +
                ", employeeID='" + employeeID + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", gender='" + gender + '\'' +
                ", genderID='" + genderID + '\'' +
                ", ethnic='" + ethnic + '\'' +
                ", ethnicID='" + ethnicID + '\'' +
                ", birthday='" + birthday + '\'' +
                ", identityCardType='" + identityCardType + '\'' +
                ", identityCardNo='" + identityCardNo + '\'' +
                ", familyPopulation='" + familyPopulation + '\'' +
                ", labourForcePopulation='" + labourForcePopulation + '\'' +
                ", education='" + education + '\'' +
                ", educationID='" + educationID + '\'' +
                ", marriage='" + marriage + '\'' +
                ", marriageID='" + marriageID + '\'' +
                ", spouseName='" + spouseName + '\'' +
                ", spousePhone='" + spousePhone + '\'' +
                ", distance='" + distance + '\'' +
                ", spouseIdentityCardNo='" + spouseIdentityCardNo + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                ", householdType='" + householdType + '\'' +
                ", householdAddress='" + householdAddress + '\'' +
                ", residentType='" + residentType + '\'' +
                ", residentTypeID='" + residentTypeID + '\'' +
                ", village='" + village + '\'' +
                ", villageID='" + villageID + '\'' +
                ", streetID='" + streetID + '\'' +
                ", street='" + street + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", groupID='" + groupID + '\'' +
                ", age='" + age + '\'' +
                ", identityCardTypeID='" + identityCardTypeID + '\'' +
                ", editflag='" + editflag + '\'' +
                ", isDelete='" + isDelete + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", customerStatus='" + customerStatus + '\'' +
                ", syncFailReason='" + syncFailReason + '\'' +
                ", abbr='" + abbr + '\'' +
                ", clientLevel='" + clientLevel + '\'' +
                ", idCardAddress='" + idCardAddress + '\'' +
                ", idCardAwardOrg='" + idCardAwardOrg + '\'' +
                ", idCardEffectivePeriodBegin='" + idCardEffectivePeriodBegin + '\'' +
                ", idCardEffectivePeriodEnd='" + idCardEffectivePeriodEnd + '\'' +
                ", bankCardList=" + bankCardList +
                '}';
    }
    // KEEP METHODS END

}