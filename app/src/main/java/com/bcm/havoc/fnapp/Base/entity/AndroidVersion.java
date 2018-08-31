package com.bcm.havoc.fnapp.Base.entity;

public class AndroidVersion implements java.io.Serializable {
    public AndroidVersion() {

    }

    public AndroidVersion(Integer versionId, Integer isForceUpdate, String version, String createTime, String apkUrl) {
        this.versionId = versionId;
        this.isForceUpdate = isForceUpdate;
        this.version = version;
        this.createTime = createTime;
        this.apkUrl = apkUrl;
    }

    private Integer versionId;
    /** 是否强制更新，1为强制更新，0为不需要强制更新 */
    private Integer isForceUpdate;

    /** 版本号 */
    private String version;

    /** 创建时间 */
    private String createTime;

    /** Apk网络地址 */
    private String apkUrl;



    /**
     * 获取 VersionId 的值
     * @return Integer
     */
    public Integer getVersionId() {
        return versionId;
    }
    
    /**
     * 设置VersionId 的值
     *
     */
    public AndroidVersion setVersionId(Integer versionId) {
        this.versionId = versionId;
        return this;
    }

    /**
     * 获取 是否强制更新，1为强制更新，0为不需要强制更新 的值
     * @return Integer
     */
    public Integer getIsForceUpdate() {
        return isForceUpdate;
    }
    
    /**
     * 设置是否强制更新，1为强制更新，0为不需要强制更新 的值
     *
     */
    public AndroidVersion setIsForceUpdate(Integer isForceUpdate) {
        this.isForceUpdate = isForceUpdate;
        return this;
    }

    /**
     * 获取 版本号 的值
     * @return String
     */
    public String getVersion() {
        return version;
    }
    
    /**
     * 设置版本号 的值
     *
     */
    public AndroidVersion setVersion(String version) {
        this.version = version;
        return this;
    }

    /**
     * 获取 创建时间 的值
     * @return String
     */
    public String getCreateTime() {
        return createTime;
    }
    
    /**
     * 设置创建时间 的值
     *
     */
    public AndroidVersion setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    /**
     * 获取 Apk网络地址 的值
     * @return String
     */
    public String getApkUrl() {
        return apkUrl;
    }
    
    /**
     * 设置Apk网络地址 的值
     *
     */
    public AndroidVersion setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
        return this;
    }

    @Override
    public String toString() {
        return "AndroidVersion{" +
                "versionId=" + versionId +
                ", isForceUpdate=" + isForceUpdate +
                ", version='" + version + '\'' +
                ", createTime='" + createTime + '\'' +
                ", apkUrl='" + apkUrl + '\'' +
                '}';
    }
}