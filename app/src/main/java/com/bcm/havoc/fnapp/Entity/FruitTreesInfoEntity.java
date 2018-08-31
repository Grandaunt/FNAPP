package com.bcm.havoc.fnapp.Entity;

import java.util.List;

/**
 * @Author misolamiso.
 * @Date 2018/8/28-19:02
 */
public class FruitTreesInfoEntity {
    public FruitTreesInfoEntity() {
    }

    public FruitTreesInfoEntity(String id, String kind, List<String> photos, String area) {
        this.id = id;
        this.kind = kind;
        this.photos = photos;
        this.area = area;
    }

    //    @SerializedName("CODE")
//    @Expose(deserialize = true,serialize = false)
//    @Column(name = "Id", isId = true, autoGen = true)
    private String id;
    //果农姓名
    private String kind;
    //照片组合
    private List<String> photos;
    //面积
    private String area ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<String> getphotos() {
        return photos;
    }

    public void setphotos(List<String> photos) {
        this.photos = photos;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "FruitTreesInfoEntity{" +
                "id='" + id + '\'' +
                ", kind='" + kind + '\'' +
                ", photos=" + photos +
                ", area='" + area + '\'' +
                '}';
    }
}
