package com.bcm.havoc.fnapp.Entity;

import java.util.List;

/**
 * @Author misolamiso.
 * @Date 2018/8/28-19:02
 */
public class BeesInfoEntity {
    public BeesInfoEntity() {
    }

    public BeesInfoEntity(String id, String kind, List<String> photos, String num) {
        this.id = id;
        this.kind = kind;
        this.photos = photos;
        this.num = num;
    }

    //    @SerializedName("CODE")
//    @Expose(deserialize = true,serialize = false)
//    @Column(name = "Id", isId = true, autoGen = true)
    private String id;
    //种类1.黑小蜜蜂2、黑大蜜蜂3、大蜜蜂4、沙巴蜂5、西方蜜蜂6、绿努蜂7、苏拉威西蜂8、东方蜜蜂9、熊蜂
    private String kind;
    //照片组合
    private List<String> photos;
    //蜂群数量
    private String num ;

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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "BeesInfoEntity{" +
                "id='" + id + '\'' +
                ", kind='" + kind + '\'' +
                ", photos=" + photos +
                ", num='" + num + '\'' +
                '}';
    }
}
