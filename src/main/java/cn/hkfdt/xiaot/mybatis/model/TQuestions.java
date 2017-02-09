package cn.hkfdt.xiaot.mybatis.model;

import java.io.Serializable;

public class TQuestions implements Serializable {
    private Integer questionId;

    /**
     * <pre>
     * 表字段注释 : 交易所"CF"中金 "SHF"上期 "DCE"大商 "CZC"郑商
     * 表字段 : xiaot_questions.exchangeCode
     * </pre>
     */
    private String exchangeCode;

    /**
     * <pre>
     * 表字段注释 : 代码缩写，比如A    实际我们表中JM1601.DCE 
     * 表字段 : xiaot_questions.shortSymbol
     * </pre>
     */
    private String shortSymbol;

    /**
     * <pre>
     * 表字段注释 : 2016-08-12.   如果是股票就是一个时间段（A;B）
     * 表字段 : xiaot_questions.tradeDay
     * </pre>
     */
    private String tradeDay;

    /**
     * <pre>
     * 表字段注释 : 创建时间
     * 表字段 : xiaot_questions.createTime
     * </pre>
     */
    private Long createTime;

    /**
     * <pre>
     * 表字段注释 : 类型，0：期货战绩  1:股票  2：外汇
     * 表字段 : xiaot_questions.type
     * </pre>
     */
    private Integer type;

    /**
     * <pre>
     * 表字段注释 : 题目类型：up,down,shock  上涨，下跌，震荡
     * 表字段 : xiaot_questions.topicType
     * </pre>
     */
    private String topicType;

    /**
     * <pre>
     * 表字段注释 : 0:jsonData 还没有被初始化  1：初始化完成  -1：历史行情少于预期值79  -2：当日分钟行少于预期值
     * 表字段 : xiaot_questions.initType
     * </pre>
     */
    private Integer initType;

    /**
     * <pre>
     * 表字段注释 : 小T的版本。小T升级后如果历史数据会变动，那就需要一个版本字段来控制新增的数据。每次变动版本加1
     * 表字段 : xiaot_questions.version
     * </pre>
     */
    private Integer version;

    /**
     * <pre>
     * 表字段注释 : 传给前端的行情数据总和.第一次为空，有人请求后创建。数据经过压缩
     * 表字段 : xiaot_questions.jsonData
     * </pre>
     */
    private byte[] jsonData;

    private static final long serialVersionUID = 1L;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getExchangeCode() {
        return exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode == null ? null : exchangeCode.trim();
    }

    public String getShortSymbol() {
        return shortSymbol;
    }

    public void setShortSymbol(String shortSymbol) {
        this.shortSymbol = shortSymbol == null ? null : shortSymbol.trim();
    }

    public String getTradeDay() {
        return tradeDay;
    }

    public void setTradeDay(String tradeDay) {
        this.tradeDay = tradeDay == null ? null : tradeDay.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType == null ? null : topicType.trim();
    }

    public Integer getInitType() {
        return initType;
    }

    public void setInitType(Integer initType) {
        this.initType = initType;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public byte[] getJsonData() {
        return jsonData;
    }

    public void setJsonData(byte[] jsonData) {
        this.jsonData = jsonData;
    }
}