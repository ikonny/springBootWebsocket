package cn.hkfdt.xiaot.web.xiaot.util;

/**
 * xiaot进来的用户类型
 * @return
 * @author whyse
 * @Date 2017/2/23 10:49
*/
public enum XiaoTUserType {

	FdtUser(1,"FdtUser"),WxUser(2,"WxUser"),OtherUser(3,"OtherUser");

	//=====================
	private int type;
	private String code;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	XiaoTUserType(int type, String code){
		this.type = type;
		this.code = code;
	}

}
