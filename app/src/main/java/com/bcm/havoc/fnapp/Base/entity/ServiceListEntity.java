package com.bcm.havoc.fnapp.Base.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by win on 2017/8/25.
 */

public class ServiceListEntity<T>  implements Serializable {
//    CompanyPracticePost

    public ServiceListEntity() {

    }
    public ServiceListEntity(String status, String msg, List<T> data) {
        Status = status;
        Msg = msg;
        Data = data;
    }
    public String Status ;
    private String Msg;
    private List<T> Data;

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

    public List<T> getData() {
        return Data;
    }

    public void setData(List<T> data) {
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
