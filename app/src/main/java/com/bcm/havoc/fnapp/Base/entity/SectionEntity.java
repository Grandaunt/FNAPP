package com.bcm.havoc.fnapp.Base.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public abstract class SectionEntity<T>  implements Serializable {
    public boolean isHeader;
    public T t;
    public String header;

    public SectionEntity(boolean isHeader, String header) {
        this.isHeader = isHeader;
        this.header = header;
        this.t = null;
    }

    public SectionEntity(T t) {
        this.isHeader = false;
        this.header = null;
        this.t = t;
    }

    /**
     * Created by win on 2017/8/25.
     */

    public static class ServiceEntity<T>  implements Serializable {
    //    CompanyPracticePost
    public ServiceEntity() {

    }

        public ServiceEntity(String status, String msg, T data) {
            Status = status;
            Msg = msg;
            Data = data;
        }
        @SerializedName("Status")
        public String Status ;
        @SerializedName("Msg")
        private String Msg;
        @SerializedName("Data")
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
            return "ServiceEntity{" +
                    "Status=" + Status +
                    ", Msg='" + Msg + '\'' +
                    ", Data=" + Data +
                    '}';
        }
    }
}
