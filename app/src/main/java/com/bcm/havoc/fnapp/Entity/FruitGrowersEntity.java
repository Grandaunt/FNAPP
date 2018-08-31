package com.bcm.havoc.fnapp.Entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Author misolamiso.
 * @Date 2018/8/17-15:16
 */
//@Table(name = "UserEntity")
public class FruitGrowersEntity implements Serializable {
    public FruitGrowersEntity() {
    }

    public FruitGrowersEntity(String id, String growers_name, String farm_name, String address, String farm_age, String phone, String web, String total_area, List<FruitTreesInfoEntity> fruitTreesInfoEntitylist) {
        this.id = id;
        this.growers_name = growers_name;
        this.farm_name = farm_name;
        this.address = address;
        this.farm_age = farm_age;
        this.phone = phone;
        this.web = web;
        this.total_area = total_area;
        this.fruitTreesInfoEntitylist = fruitTreesInfoEntitylist;
    }

    //    @SerializedName("CODE")
//    @Expose(deserialize = true,serialize = false)
//    @Column(name = "Id", isId = true, autoGen = true)
    private String id;
    //果农姓名
    private String growers_name;
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
    //总面积
    private String total_area ;
    //果树list
    private List<FruitTreesInfoEntity> fruitTreesInfoEntitylist;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrowers_name() {
        return growers_name;
    }

    public void setGrowers_name(String growers_name) {
        this.growers_name = growers_name;
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

    public String getTotal_area() {
        return total_area;
    }

    public void setTotal_area(String total_area) {
        this.total_area = total_area;
    }

    public List<FruitTreesInfoEntity> getFruitTreesInfoEntitylist() {
        return fruitTreesInfoEntitylist;
    }

    public void setFruitTreesInfoEntitylist(List<FruitTreesInfoEntity> fruitTreesInfoEntitylist) {
        this.fruitTreesInfoEntitylist = fruitTreesInfoEntitylist;
    }

    @Override
    public String toString() {
        return "FruitGrowersEntity{" +
                "id='" + id + '\'' +
                ", growers_name='" + growers_name + '\'' +
                ", farm_name='" + farm_name + '\'' +
                ", address='" + address + '\'' +
                ", farm_age='" + farm_age + '\'' +
                ", phone='" + phone + '\'' +
                ", web='" + web + '\'' +
                ", total_area='" + total_area + '\'' +
                ", fruitTreesInfoEntitylist=" + fruitTreesInfoEntitylist +
                '}';
    }
}
