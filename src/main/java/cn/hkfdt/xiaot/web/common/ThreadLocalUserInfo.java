package cn.hkfdt.xiaot.web.common;

/**
 * Created by hzzhaopingfei on 2015/10/7.
 * Powered by Rock
 */
public class ThreadLocalUserInfo {

    /**
     * main System user id
     */
    private String fdtId;

    public String getFdtId() {
        return fdtId;
    }

    public void setFdtId(String fdtId) {
        this.fdtId = fdtId;
    }

    private boolean isTestParameter = false;

    public boolean isTestParameter() {
        return isTestParameter;
    }

    public void setTestParameter(boolean testParameter) {
        isTestParameter = testParameter;
    }

}
