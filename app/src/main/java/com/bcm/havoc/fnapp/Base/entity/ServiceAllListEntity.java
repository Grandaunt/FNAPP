package com.bcm.havoc.fnapp.Base.entity;

import java.io.Serializable;

/**
 * Created by win on 2017/8/25.
 */

public class ServiceAllListEntity<T>  implements Serializable {
//    CompanyPracticePost

    public ServiceAllListEntity() {

    }
    public ServiceAllListEntity(String status, String msg, T data) {
        Status = status;
        Msg = msg;
        Data = data;
    }
    public String Status ;
    private String Msg;
    private T Data;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    @Override
    public String toString() {
        return "ServiceListEntity{" +
                "Status=" + Status +
                ", Msg='" + Msg + '\'' +
                ", Data=" + Data +
                '}';
    }
}
