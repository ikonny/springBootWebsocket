package cn.hkfdt.xiaot.web.common.meta;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BrokerInfoRenderObj{

    private String brokerid;

    private String brokername;

    private String type;

    private String tag;

    private String brokerurl;

    private String icon;

    private String intro;

    private String sequence_num;

    private String branchId;

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getSequence_num() {
        return sequence_num;
    }

    public void setSequence_num(String sequence_num) {
        this.sequence_num = sequence_num;
    }

    public String getBrokerid() {
        return brokerid;
    }

    public void setBrokerid(String brokerid) {
        this.brokerid = brokerid;
    }

    public String getBrokername() {
        return brokername;
    }

    public void setBrokername(String brokername) {
        this.brokername = brokername;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getBrokerurl() {
        return brokerurl;
    }

    public void setBrokerurl(String brokerurl) {
        this.brokerurl = brokerurl;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}