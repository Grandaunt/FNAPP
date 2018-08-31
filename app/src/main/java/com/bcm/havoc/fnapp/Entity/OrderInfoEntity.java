package com.bcm.havoc.fnapp.Entity;

/**
 * @Author misolamiso.
 * @Date 2018/8/28-19:16
 */
public class OrderInfoEntity {
    public OrderInfoEntity() {
    }

    public OrderInfoEntity(FruitGrowersEntity fruitGrowersEntity, BeekeePerEntity beekeePerEntity, String status) {
        this.fruitGrowersEntity = fruitGrowersEntity;
        this.beekeePerEntity = beekeePerEntity;
        this.status = status;
    }

    //果农
    private FruitGrowersEntity fruitGrowersEntity;
    //蜂农
    private BeekeePerEntity beekeePerEntity;
    //完成情况 0：初始状态，1：未达成订单，2：达成订单未完成，3：订单中止，4：订单完成
    private String status;

    public FruitGrowersEntity getFruitGrowersEntity() {
        return fruitGrowersEntity;
    }

    public void setFruitGrowersEntity(FruitGrowersEntity fruitGrowersEntity) {
        this.fruitGrowersEntity = fruitGrowersEntity;
    }

    public BeekeePerEntity getBeekeePerEntity() {
        return beekeePerEntity;
    }

    public void setBeekeePerEntity(BeekeePerEntity beekeePerEntity) {
        this.beekeePerEntity = beekeePerEntity;
    }

    public String getStatus() {
        return status;
    }

    public void getStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderInfoEntity{" +
                "fruitGrowersEntity=" + fruitGrowersEntity +
                ", beekeePerEntity=" + beekeePerEntity +
                ", status='" + status + '\'' +
                '}';
    }
}
