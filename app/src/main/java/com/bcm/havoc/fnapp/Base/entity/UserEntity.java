package com.bcm.havoc.fnapp.Base.entity;

import java.io.Serializable;

/**
 * @Author misolamiso.
 * @Date 2018/8/17-15:16
 */
//@Table(name = "UserEntity")
public class UserEntity  implements Serializable {
    public UserEntity() {
    }

    public UserEntity(String id, String carNumber, String plateNumber, String driverName, String telephone, String carType, String sendType, String startPosition, String endPosition, String idCard, String bank, String bankAccount, String inviter, String drivingYears, String cooperationNum) {
        Id = id;
        CarNumber = carNumber;
        PlateNumber = plateNumber;
        DriverName = driverName;
        Telephone = telephone;
        CarType = carType;
        SendType = sendType;
        StartPosition = startPosition;
        EndPosition = endPosition;
        IdCard = idCard;
        Bank = bank;
        BankAccount = bankAccount;
        Inviter = inviter;
        DrivingYears = drivingYears;
        CooperationNum = cooperationNum;
    }

//    @SerializedName("CODE")
//    @Expose(deserialize = true,serialize = false)
//    @Column(name = "Id", isId = true, autoGen = true)
    private String Id;
    //车辆编号
    private String CarNumber;
    //车牌号码
    private String PlateNumber;

    //司机姓名
    private String DriverName;

    //手机号
    private String Telephone;
    //车辆类型：1:货车、2:客车、3:面包车、4:轿车
    private String CarType;
    //配送类型 1:全天配送 2：顺路配送
    private String SendType;
    //始发地
    private String StartPosition;
    //目的地
    private String EndPosition;
    //身份证
    private String IdCard;
    //开户银行
    private String Bank;
    //银行账号
    private String BankAccount;
    //邀请人
    private String Inviter;
    //驾龄
    private String DrivingYears;
    //合作次数
    private String CooperationNum;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCarNumber() {
        return CarNumber;
    }

    public void setCarNumber(String carNumber) {
        CarNumber = carNumber;
    }

    public String getPlateNumber() {
        return PlateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        PlateNumber = plateNumber;
    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getCarType() {
        return CarType;
    }

    public void setCarType(String carType) {
        CarType = carType;
    }

    public String getSendType() {
        return SendType;
    }

    public void setSendType(String sendType) {
        SendType = sendType;
    }

    public String getStartPosition() {
        return StartPosition;
    }

    public void setStartPosition(String startPosition) {
        StartPosition = startPosition;
    }

    public String getEndPosition() {
        return EndPosition;
    }

    public void setEndPosition(String endPosition) {
        EndPosition = endPosition;
    }

    public String getIdCard() {
        return IdCard;
    }

    public void setIdCard(String idCard) {
        IdCard = idCard;
    }

    public String getBank() {
        return Bank;
    }

    public void setBank(String bank) {
        Bank = bank;
    }

    public String getBankAccount() {
        return BankAccount;
    }

    public void setBankAccount(String bankAccount) {
        BankAccount = bankAccount;
    }

    public String getInviter() {
        return Inviter;
    }

    public void setInviter(String inviter) {
        Inviter = inviter;
    }

    public String getDrivingYears() {
        return DrivingYears;
    }

    public void setDrivingYears(String drivingYears) {
        DrivingYears = drivingYears;
    }

    public String getCooperationNum() {
        return CooperationNum;
    }

    public void setCooperationNum(String cooperationNum) {
        CooperationNum = cooperationNum;
    }

    @Override
    public String toString() {
        return "DriverEntity{" +
                "Id='" + Id + '\'' +
                ", CarNumber='" + CarNumber + '\'' +
                ", PlateNumber='" + PlateNumber + '\'' +
                ", DriverName='" + DriverName + '\'' +
                ", Telephone='" + Telephone + '\'' +
                ", CarType='" + CarType + '\'' +
                ", SendType='" + SendType + '\'' +
                ", StartPosition='" + StartPosition + '\'' +
                ", EndPosition='" + EndPosition + '\'' +
                ", IdCard='" + IdCard + '\'' +
                ", Bank='" + Bank + '\'' +
                ", BankAccount='" + BankAccount + '\'' +
                ", Inviter='" + Inviter + '\'' +
                ", DrivingYears='" + DrivingYears + '\'' +
                ", CooperationNum='" + CooperationNum + '\'' +
                '}';
    }
}
