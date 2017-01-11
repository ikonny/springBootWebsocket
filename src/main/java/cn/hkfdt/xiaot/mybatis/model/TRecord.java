package cn.hkfdt.xiaot.mybatis.model;

import java.io.Serializable;

public class TRecord implements Serializable {
    private Integer recordid;

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
    private String fdtid;

    /**
     * <pre>
     * 表字段注释 : 训练时间
     * 表字段 : xiaot_record.tradeTime
     * </pre>
     */
    private String tradetime;

    /**
     * <pre>
     * 表字段注释 : 收益率2.01   自动隐去%
     * 表字段 : xiaot_record.returnRate
     * </pre>
     */
    private Float returnrate;

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
    private Long createtime;

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
    private String questionkey;

    /**
     * <pre>
     * 表字段注释 : 买卖点json数组,一个行动40字符
     * 表字段 : xiaot_record.actions
     * </pre>
     */
    private String actions;

    private static final long serialVersionUID = 1L;

    public Integer getRecordid() {
        return recordid;
    }

    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol == null ? null : symbol.trim();
    }

    public String getFdtid() {
        return fdtid;
    }

    public void setFdtid(String fdtid) {
        this.fdtid = fdtid == null ? null : fdtid.trim();
    }

    public String getTradetime() {
        return tradetime;
    }

    public void setTradetime(String tradetime) {
        this.tradetime = tradetime == null ? null : tradetime.trim();
    }

    public Float getReturnrate() {
        return returnrate;
    }

    public void setReturnrate(Float returnrate) {
        this.returnrate = returnrate;
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

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getQuestionkey() {
        return questionkey;
    }

    public void setQuestionkey(String questionkey) {
        this.questionkey = questionkey == null ? null : questionkey.trim();
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions == null ? null : actions.trim();
    }
}