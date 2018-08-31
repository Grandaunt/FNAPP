package com.bcm.havoc.fnapp.Entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Author misolamiso.
 * @Date 2018/8/17-15:16
 */
//@Table(name = "UserEntity")
public class BeekeePerEntity implements Serializable {
    public BeekeePerEntity() {
    }

    public BeekeePerEntity(String id, String beekeepers_name, String farm_name, String address, String farm_age, String phone, String web, String total_num, String service_area_hight, String service_area_low, String service_time_hight, String service_time_low, String service_price_hight, String service_price_low, List<BeesInfoEntity> beesInfoEntitlist) {
        this.id = id;
        this.beekeepers_name = beekeepers_name;
        this.farm_name = farm_name;
        this.address = address;
        this.farm_age = farm_age;
        this.phone = phone;
        this.web = web;
        this.total_num = total_num;
        this.service_area_hight = service_area_hight;
        this.service_area_low = service_area_low;
        this.service_time_hight = service_time_hight;
        this.service_time_low = service_time_low;
        this.service_price_hight = service_price_hight;
        this.service_price_low = service_price_low;
        this.beesInfoEntitlist = beesInfoEntitlist;
    }

    //    @SerializedName("CODE")
//    @Expose(deserialize = true,serialize = false)
//    @Column(name = "Id", isId = true, autoGen = true)
    private String id;
    //蜂农姓名
    private String beekeepers_name;
    //农场名称
    private String farm_name;
    //农场地理位置
    private String address;
    //农场年限
    private String farm_age;
    //联系方式
    private String phone;
    //网址
    private String web;
    //蜜蜂总数量
    private String total_num ;
    //提供服务最远距离
    private String service_area_hight ;
    //提供服务最近距离
    private String service_area_low ;
    //提供服务最长时间
    private String service_time_hight ;
    //提供服务最短时间
    private String service_time_low ;
    //提供服务最多价钱
    private String service_price_hight ;
    //提供服务最少价钱
    private String service_price_low ;
    //蜜蜂list
    private List<BeesInfoEntity> beesInfoEntitlist;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBeekeepers_name() {
        return beekeepers_name;
    }

    public void setBeekeepers_name(String beekeepers_name) {
        this.beekeepers_name = beekeepers_name;
    }

    public String getFarm_name() {
        return farm_name;
    }

    public void setFarm_name(String farm_name) {
        this.farm_name = farm_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFarm_age() {
        return farm_age;
    }

    public void setFarm_age(String farm_age) {
        this.farm_age = farm_age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getTotal_num() {
        return total_num;
    }

    public void setTotal_num(String total_num) {
        this.total_num = total_num;
    }

    public String getService_area_hight() {
        return service_area_hight;
    }

    public void setService_area_hight(String service_area_hight) {
        this.service_area_hight = service_area_hight;
    }

    public String getService_area_low() {
        return service_area_low;
    }

    public void setService_area_low(String service_area_low) {
        this.service_area_low = service_area_low;
    }

    public String getService_time_hight() {
        return service_time_hight;
    }

    public void setService_time_hight(String service_time_hight) {
        this.service_time_hight = service_time_hight;
    }

    public String getService_time_low() {
        return service_time_low;
    }

    public void setService_time_low(String service_time_low) {
        this.service_time_low = service_time_low;
    }

    public String getService_price_hight() {
        return service_price_hight;
    }

    public void setService_price_hight(String service_price_hight) {
        this.service_price_hight = service_price_hight;
    }

    public String getService_price_low() {
        return service_price_low;
    }

    public void setService_price_low(String service_price_low) {
        this.service_price_low = service_price_low;
    }

    public List<BeesInfoEntity> getBeesInfoEntitlist() {
        return beesInfoEntitlist;
    }

    public void setBeesInfoEntitlist(List<BeesInfoEntity> beesInfoEntitlist) {
        this.beesInfoEntitlist = beesInfoEntitlist;
    }

    @Override
    public String toString() {
        return "BeekeePerEntity{" +
                "id='" + id + '\'' +
                ", beekeepers_name='" + beekeepers_name + '\'' +
                ", farm_name='" + farm_name + '\'' +
                ", address='" + address + '\'' +
                ", farm_age='" + farm_age + '\'' +
                ", phone='" + phone + '\'' +
                ", web='" + web + '\'' +
                ", total_num='" + total_num + '\'' +
                ", service_area_hight='" + service_area_hight + '\'' +
                ", service_area_low='" + service_area_low + '\'' +
                ", service_time_hight='" + service_time_hight + '\'' +
                ", service_time_low='" + service_time_low + '\'' +
                ", service_price_hight='" + service_price_hight + '\'' +
                ", service_price_low='" + service_price_low + '\'' +
                ", beesInfoEntitlist=" + beesInfoEntitlist +
                '}';
    }
}
