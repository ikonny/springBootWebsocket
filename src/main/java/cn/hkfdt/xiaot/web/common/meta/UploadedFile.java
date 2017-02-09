package cn.hkfdt.xiaot.web.common.meta;

import java.io.Serializable;

/**
 * Created by cuijie on 16/2/2.
 */
public class UploadedFile implements Serializable {

    private static final long serialVersionUID = 9170245315190904568L;

    private String srcName;
    private String targetName;
    private Long size;
    private String url;
    private String md5;

    private String urlDisplay;

    public String getSrcName() {
        return srcName;
    }

    public void setSrcName(String srcName) {
        this.srcName = srcName;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getUrlDisplay() {
        return urlDisplay;
    }

    public void setUrlDisplay(String urlDisplay) {
        this.urlDisplay = urlDisplay;
    }
}
