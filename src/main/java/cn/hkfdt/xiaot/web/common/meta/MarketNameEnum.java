package cn.hkfdt.xiaot.web.common.meta;

/**
 * Created by cuijie on 16/6/21.
 */
public enum MarketNameEnum {

    FOREX("FX", "Forex", "外汇", "外匯"),
    FUTURE("FC", "Futures", "期货", "期貨"),
    FUTURETW("FT", "Futures", "期货", "期貨"),
    STOCK("SC", "Stock", "股票", "股票");

    MarketNameEnum(String market, String enName, String cnName, String twName) {
        this.market = market;
        this.enName = enName;
        this.cnName = cnName;
        this.twName = twName;
    }

    private String market;

    private String twName;

    private String enName;

    private String cnName;

    public String getMarket() {
        return market;
    }

    public String getTwName() {
        return twName;
    }

    public String getEnName() {
        return enName;
    }

    public String getCnName() {
        return cnName;
    }

    public static MarketNameEnum getEnumByMarket(String market) {
        for (MarketNameEnum marketNameEnum : MarketNameEnum.values()) {
            if (marketNameEnum.getMarket().equalsIgnoreCase(market)) {
                return marketNameEnum;
            }
        }
        return MarketNameEnum.FOREX;
    }
}
