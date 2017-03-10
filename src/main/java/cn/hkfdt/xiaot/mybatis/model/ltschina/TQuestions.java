package cn.hkfdt.xiaot.mybatis.model.ltschina;

import java.io.Serializable;

public class TQuestions implements Serializable {
    private Integer questionId;

    /**
     * <pre>
     * 表字段注释 : äº¤æ˜“æ‰€"CF"ä¸­é‡‘ "SHF"ä¸ŠæœŸ "DCE"å¤§å•† "CZC"éƒ‘å•†
     * 表字段 : xiaot_questions.exchangeCode
     * </pre>
     */
    private String exchangeCode;

    /**
     * <pre>
     * 表字段注释 : ä»£ç ç¼©å†™ï¼Œæ¯”å¦‚A    å®žé™…æˆ‘ä»¬è¡¨ä¸­JM1601.DCE 
     * 表字段 : xiaot_questions.shortSymbol
     * </pre>
     */
    private String shortSymbol;

    /**
     * <pre>
     * 表字段注释 : 2016-08-12.   å¦‚æžœæ˜¯è‚¡ç¥¨å°±æ˜¯ä¸€ä¸ªæ—¶é—´æ®µï¼ˆA;Bï¼‰
     * 表字段 : xiaot_questions.tradeDay
     * </pre>
     */
    private String tradeDay;

    /**
     * <pre>
     * 表字段注释 : åˆ›å»ºæ—¶é—´
     * 表字段 : xiaot_questions.createTime
     * </pre>
     */
    private Long createTime;

    /**
     * <pre>
     * 表字段注释 : ç±»åž‹ï¼Œ0ï¼šæœŸè´§æˆ˜ç»©  1:è‚¡ç¥¨  2ï¼šå¤–æ±‡
     * 表字段 : xiaot_questions.type
     * </pre>
     */
    private Integer type;

    /**
     * <pre>
     * 表字段注释 : é¢˜ç›®ç±»åž‹ï¼šup,down,shock  ä¸Šæ¶¨ï¼Œä¸‹è·Œï¼Œéœ‡è¡
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
     * 表字段注释 : 振幅
     * 表字段 : xiaot_questions.volatility
     * </pre>
     */
    private Double volatility;

    /**
     * <pre>
     * 表字段注释 : 中文名
     * 表字段 : xiaot_questions.cnName
     * </pre>
     */
    private String cnName;

    /**
     * <pre>
     * 表字段注释 : ä¼ ç»™å‰ç«¯çš„è¡Œæƒ…æ•°æ®æ€»å’Œ.ç¬¬ä¸€æ¬¡ä¸ºç©ºï¼Œæœ‰äººè¯·æ±‚åŽåˆ›å»º
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

    public Double getVolatility() {
        return volatility;
    }

    public void setVolatility(Double volatility) {
        this.volatility = volatility;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName == null ? null : cnName.trim();
    }

    public byte[] getJsonData() {
        return jsonData;
    }

    public void setJsonData(byte[] jsonData) {
        this.jsonData = jsonData;
    }
}