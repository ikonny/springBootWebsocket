package cn.hkfdt.xiaot.web.xiaot.util;

public enum XiaoTMarketType {

	FC(0,"FC"),SC(1,"SC"),FX(2,"FX");
	
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
	XiaoTMarketType(int type,String code){
		this.type = type;
		this.code = code;
	}

}
