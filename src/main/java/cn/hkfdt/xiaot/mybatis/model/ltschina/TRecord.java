package cn.hkfdt.xiaot.mybatis.model.ltschina;

import java.io.Serializable;

public class TRecord implements Serializable {
    private Integer recordId;

    /**
     * <pre>
     * 表字段注释 : ru
     * 表字段 : xiaot_record.symbol
     * </pre>
     */
    private String symbol;

    /**
     * <pre>
     * 表字段注释 : fdtId外键
     * 表字段 : xiaot_record.fdtId
     * </pre>
     */
    private String fdtId;

    /**
     * <pre>
     * 表字段注释 : 训练时间
     * 表字段 : xiaot_record.tradeTime
     * </pre>
     */
    private String tradeTime;

    /**
     * <pre>
     * 表字段注释 : 收益率2.01   自动隐去%
     * 表字段 : xiaot_record.returnRate
     * </pre>
     */
    private Float returnRate;

    /**
     * <pre>
     * 表字段注释 : 振幅2.01
     * 表字段 : xiaot_record.volatility
     * </pre>
     */
    private Float volatility;

    /**
     * <pre>
     * 表字段注释 : 类型，0：期货战绩  1:股票  2：外汇
     * 表字段 : xiaot_record.type
     * </pre>
     */
    private Integer type;

    /**
     * <pre>
     * 表字段注释 : 创建时间
     * 表字段 : xiaot_record.createTime
     * </pre>
     */
    private Long createTime;

    /**
     * <pre>
     * 表字段注释 : 买卖点json数组,一个行动40字符
     * 表字段 : xiaot_record.actions
     * </pre>
     */
    private String actions;

    /**
     * <pre>
     * 表字段注释 : 这题得分
     * 表字段 : xiaot_record.score
     * </pre>
     */
    private Double score;

    /**
     * <pre>
     * 表字段注释 : 外部联合主键
     * 表字段 : xiaot_record.questionKey
     * </pre>
     */
    private String questionKey;

    /**
     * <pre>
     * 表字段注释 : 小T的版本。小T升级后如果历史数据会变动，那就需要一个版本字段来控制新增的数据。每次变动版本加1
     * 表字段 : xiaot_record.VERSION
     * </pre>
     */
    private Integer VERSION;

    private static final long serialVersionUID = 1L;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol == null ? null : symbol.trim();
    }

    public String getFdtId() {
        return fdtId;
    }

    public void setFdtId(String fdtId) {
        this.fdtId = fdtId == null ? null : fdtId.trim();
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime == null ? null : tradeTime.trim();
    }

    public Float getReturnRate() {
        return returnRate;
    }

    public void setReturnRate(Float returnRate) {
        this.returnRate = returnRate;
    }

    public Float getVolatility() {
        return volatility;
    }

    public void setVolatility(Float volatility) {
        this.volatility = volatility;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions == null ? null : actions.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getQuestionKey() {
        return questionKey;
    }

    public void setQuestionKey(String questionKey) {
        this.questionKey = questionKey == null ? null : questionKey.trim();
    }

    public Integer getVERSION() {
        return VERSION;
    }

    public void setVERSION(Integer VERSION) {
        this.VERSION = VERSION;
    }
}