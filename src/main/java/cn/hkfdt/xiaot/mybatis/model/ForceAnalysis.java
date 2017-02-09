package cn.hkfdt.xiaot.mybatis.model;

import java.io.Serializable;

public class ForceAnalysis implements Serializable {
    private Integer forceId;

    /**
     * <pre>
     * 表字段注释 : fdtscore
     * 表字段 : xiaot_force_analysis.fdtScore
     * </pre>
     */
    private Float fdtScore;

    /**
     * <pre>
     * 表字段注释 : 累计收益率
     * 表字段 : xiaot_force_analysis.accumulatedIncome
     * </pre>
     */
    private Float accumulatedIncome;

    /**
     * <pre>
     * 表字段注释 : fdtId外键
     * 表字段 : xiaot_force_analysis.fdtId
     * </pre>
     */
    private String fdtId;

    /**
     * <pre>
     * 表字段注释 : 训练次数
     * 表字段 : xiaot_force_analysis.tradeCount
     * </pre>
     */
    private Integer tradeCount;

    /**
     * <pre>
     * 表字段注释 : 胜利次数
     * 表字段 : xiaot_force_analysis.winCount
     * </pre>
     */
    private Integer winCount;

    /**
     * <pre>
     * 表字段注释 : 最大回撤 -0.15
     * 表字段 : xiaot_force_analysis.maxDrawdown
     * </pre>
     */
    private Float maxDrawdown;

    /**
     * <pre>
     * 表字段注释 : 年化夏普率 0.15
     * 表字段 : xiaot_force_analysis.sharpeRatio
     * </pre>
     */
    private Float sharpeRatio;

    /**
     * <pre>
     * 表字段注释 : 类型，0：期货战绩  1:股票  2：外汇
     * 表字段 : xiaot_force_analysis.type
     * </pre>
     */
    private Integer type;

    /**
     * <pre>
     * 表字段注释 : 创建时间
     * 表字段 : xiaot_force_analysis.createTime
     * </pre>
     */
    private Long createTime;

    /**
     * <pre>
     * 表字段注释 : 小T的版本。小T升级后如果历史数据会变动，那就需要一个版本字段来控制新增的数据。每次变动版本加1
     * 表字段 : xiaot_force_analysis.VERSION
     * </pre>
     */
    private Integer VERSION;

    private static final long serialVersionUID = 1L;

    public Integer getForceId() {
        return forceId;
    }

    public void setForceId(Integer forceId) {
        this.forceId = forceId;
    }

    public Float getFdtScore() {
        return fdtScore;
    }

    public void setFdtScore(Float fdtScore) {
        this.fdtScore = fdtScore;
    }

    public Float getAccumulatedIncome() {
        return accumulatedIncome;
    }

    public void setAccumulatedIncome(Float accumulatedIncome) {
        this.accumulatedIncome = accumulatedIncome;
    }

    public String getFdtId() {
        return fdtId;
    }

    public void setFdtId(String fdtId) {
        this.fdtId = fdtId == null ? null : fdtId.trim();
    }

    public Integer getTradeCount() {
        return tradeCount;
    }

    public void setTradeCount(Integer tradeCount) {
        this.tradeCount = tradeCount;
    }

    public Integer getWinCount() {
        return winCount;
    }

    public void setWinCount(Integer winCount) {
        this.winCount = winCount;
    }

    public Float getMaxDrawdown() {
        return maxDrawdown;
    }

    public void setMaxDrawdown(Float maxDrawdown) {
        this.maxDrawdown = maxDrawdown;
    }

    public Float getSharpeRatio() {
        return sharpeRatio;
    }

    public void setSharpeRatio(Float sharpeRatio) {
        this.sharpeRatio = sharpeRatio;
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

    public Integer getVERSION() {
        return VERSION;
    }

    public void setVERSION(Integer VERSION) {
        this.VERSION = VERSION;
    }
}