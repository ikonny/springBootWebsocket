package cn.hkfdt.xiaot.mybatis.model.ltschina;

import java.io.Serializable;
import java.util.Date;

public class School implements Serializable {
    private String schoolKey;

    private String enName;

    private String enShort;

    private String scName;

    private String scPinyin;

    private String tcName;

    private String region;

    private Boolean displayEn;

    private Boolean displaySc;

    private Boolean displayTc;

    private String domains;

    private String flagUrl;

    private String ossFlagUrl;

    private String groupId;

    private String deviceLanguage;

    private Boolean isDel;

    private Date publishTime;

    private Date lastUpdateTime;

    private static final long serialVersionUID = 1L;

    public String getSchoolKey() {
        return schoolKey;
    }

    public void setSchoolKey(String schoolKey) {
        this.schoolKey = schoolKey == null ? null : schoolKey.trim();
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    public String getEnShort() {
        return enShort;
    }

    public void setEnShort(String enShort) {
        this.enShort = enShort == null ? null : enShort.trim();
    }

    public String getScName() {
        return scName;
    }

    public void setScName(String scName) {
        this.scName = scName == null ? null : scName.trim();
    }

    public String getScPinyin() {
        return scPinyin;
    }

    public void setScPinyin(String scPinyin) {
        this.scPinyin = scPinyin == null ? null : scPinyin.trim();
    }

    public String getTcName() {
        return tcName;
    }

    public void setTcName(String tcName) {
        this.tcName = tcName == null ? null : tcName.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public Boolean getDisplayEn() {
        return displayEn;
    }

    public void setDisplayEn(Boolean displayEn) {
        this.displayEn = displayEn;
    }

    public Boolean getDisplaySc() {
        return displaySc;
    }

    public void setDisplaySc(Boolean displaySc) {
        this.displaySc = displaySc;
    }

    public Boolean getDisplayTc() {
        return displayTc;
    }

    public void setDisplayTc(Boolean displayTc) {
        this.displayTc = displayTc;
    }

    public String getDomains() {
        return domains;
    }

    public void setDomains(String domains) {
        this.domains = domains == null ? null : domains.trim();
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl == null ? null : flagUrl.trim();
    }

    public String getOssFlagUrl() {
        return ossFlagUrl;
    }

    public void setOssFlagUrl(String ossFlagUrl) {
        this.ossFlagUrl = ossFlagUrl == null ? null : ossFlagUrl.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getDeviceLanguage() {
        return deviceLanguage;
    }

    public void setDeviceLanguage(String deviceLanguage) {
        this.deviceLanguage = deviceLanguage == null ? null : deviceLanguage.trim();
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}