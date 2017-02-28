package cn.hkfdt.xiaot.mybatis.model.ltschina;

import java.io.Serializable;

public class TGame implements Serializable {
    private Integer id;

    /**
     * <pre>
     * 表字段注释 : 比赛Id标记比赛
     * 表字段 : xiaot_game.gameId
     * </pre>
     */
    private String gameId;

    /**
     * <pre>
     * 表字段注释 : 比赛名
     * 表字段 : xiaot_game.gameName
     * </pre>
     */
    private String gameName;

    /**
     * <pre>
     * 表字段注释 : 0:期货  1:外汇 2股票
     * 表字段 : xiaot_game.marketType
     * </pre>
     */
    private Integer marketType;

    /**
     * <pre>
     * 表字段注释 : 比赛人数
     * 表字段 : xiaot_game.userNum
     * </pre>
     */
    private Integer userNum;

    /**
     * <pre>
     * 表字段注释 : 实际参数人数
     * 表字段 : xiaot_game.realNum
     * </pre>
     */
    private Integer realNum;

    private Long createTime;

    private Long updateTime;

    /**
     * <pre>
     * 表字段注释 : 0:创建  1:进行中  2:结束
     * 表字段 : xiaot_game.state
     * </pre>
     */
    private Integer state;

    /**
     * <pre>
     * 表字段注释 : 选题主键
     * 表字段 : xiaot_game.questionId
     * </pre>
     */
    private Integer questionId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId == null ? null : gameId.trim();
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName == null ? null : gameName.trim();
    }

    public Integer getMarketType() {
        return marketType;
    }

    public void setMarketType(Integer marketType) {
        this.marketType = marketType;
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    public Integer getRealNum() {
        return realNum;
    }

    public void setRealNum(Integer realNum) {
        this.realNum = realNum;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}