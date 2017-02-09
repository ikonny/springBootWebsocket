package cn.hkfdt.xiaot.web.common.meta;

/**
 * Created by zhaopingfei on 2015/11/5.
 * Powered by Rock
 */
public enum AppNameEnum {
    FOREXMASTER("FX", "ForexMaster", "外汇操盘手", "外匯操盤手", "FDT操盘手", "FDT操盤手", "FDT Trader"),
    FOREXMASTERLIVE("FX", "ForexMasterLive", "外汇操盘手", "外匯操盤手", "FDT操盘手", "FDT操盤手", "FDT Trader"),
    FOREXMASTERINC("FX", "ForexMasterInc", "外汇操盘手", "外匯操盤手", "FDT操盘手", "FDT操盤手", "FDT Trader"),
    FUTURESMASTER("FC", "FuturesMaster", "期货操盘手", "期貨操盤手", "FDT操盘手", "FDT操盤手", "FDT Trader"),
    FUTURESMASTERLIVE("FC", "FuturesMasterLive", "期货操盘手", "期貨操盤手", "FDT操盘手", "FDT操盤手", "FDT Trader"),
    STOCKMASTER("SC", "StockMaster", "股市操盘手", "股市操盤手", "FDT操盘手", "FDT操盤手", "FDT Trader"),
    NEWBACKEND("BK", "AdminBackend", "FDT管理后台", "FDT管理后台", "FDT管理后台", "FDT管理後台", "FDT Admin"),
    FDTWEALTH("WM", "FDTWealth", "蜂投财富", "蜂投財富", "蜂投财富", "蜂投財富", "FDT Wealth");

    AppNameEnum(String type, String allName, String chinaName, String twName, String newName, String twNewName, String newEnName) {
        this.type = type;
        this.allName = allName;
        this.chinaName = chinaName;
        this.twName = twName;
        this.newName = newName;
        this.twNewName = twNewName;
        this.newEnName = newEnName;
    }

    private String type;

    private String allName;

    private String chinaName;

    private String twName;

    private String newName;

    private String twNewName;

    private String newEnName;

    public String getTwNewName() {
        return twNewName;
    }

    public String getNewEnName() {
        return newEnName;
    }

    public String getNewName() {
        return newName;
    }

    public String getTwName() {
        return twName;
    }

    public String getChinaName() {
        return chinaName;
    }

    public String getType() {
        return type;
    }

    public String getAllName() {
        return allName;
    }

    public static AppNameEnum getEnumByFullName(String appName) {
        for (AppNameEnum appNameEnum : AppNameEnum.values()) {
            if (appNameEnum.getAllName().equalsIgnoreCase(appName)) {
                return appNameEnum;
            }
        }
        return null;
    }

    public static AppNameEnum getEnumByType(String type) {
        for (AppNameEnum appNameEnum : AppNameEnum.values()) {
            if (appNameEnum.getType().equalsIgnoreCase(type)) {
                return appNameEnum;
            }
        }
        return AppNameEnum.FOREXMASTER;
    }
}
