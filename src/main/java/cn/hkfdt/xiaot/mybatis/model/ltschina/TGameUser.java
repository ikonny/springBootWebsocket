package cn.hkfdt.xiaot.mybatis.model.ltschina;

import java.io.Serializable;

public class TGameUser implements Serializable {
    private Integer id;

    /**
     * <pre>
     * 表字段注释 : 比赛Id
     * 表字段 : xiaot_game_user.gameId
     * </pre>
     */
    private String gameId;

    /**
     * <pre>
     * 表字段注释 : 用户id
     * 表字段 : xiaot_game_user.userId
     * </pre>
     */
    private String userId;

    /**
     * <pre>
     * 表字段注释 : 1:fdt  2:微信 3其他
     * 表字段 : xiaot_game_user.userType
     * </pre>
     */
    private Integer userType;

    /**
     * <pre>
     * 表字段注释 : 昵称
     * 表字段 : xiaot_game_user.nickName
     * </pre>
     */
    private String nickName;

    private Long createTime;

    private Long updateTime;

    /**
     * <pre>
     * 表字段注释 : 0:创建  1:进行中  2:结束
     * 表字段 : xiaot_game_user.state
     * </pre>
     */
    private Integer state;

    /**
     * <pre>
     * 表字段注释 : 选题主键冗余字段
     * 表字段 : xiaot_game_user.questionId
     * </pre>
     */
    private Integer questionId;

    /**
     * <pre>
     * 表字段注释 : 收益率2.01   自动隐去%
     * 表字段 : xiaot_game_user.returnRate
     * </pre>
     */
    private Double returnRate;

    /**
     * <pre>
     * 表字段注释 : 振幅2.01
     * 表字段 : xiaot_game_user.volatility
     * </pre>
     */
    private Double volatility;

    /**
     * <pre>
     * 表字段注释 : 类型，0：期货战绩  1:股票  2：外汇
     * 表字段 : xiaot_game_user.marketType
     * </pre>
     */
    private Integer marketType;

    /**
     * <pre>
     * 表字段注释 : 买卖点json数组,一个行动40字符
     * 表字段 : xiaot_game_user.actions
     * </pre>
     */
    private String actions;

    /**
     * <pre>
     * 表字段注释 : 这题得分
     * 表字段 : xiaot_game_user.score
     * </pre>
     */
    private Double score;

    /**
     * <pre>
     * 表字段注释 : 排名，从1开始计算
     * 表字段 : xiaot_game_user.ranking
     * </pre>
     */
    private Integer ranking;

    /**
     * <pre>
     * 表字段注释 : 小T的版本。小T升级后如果历史数据会变动，那就需要一个版本字段来控制新增的数据。
            每次变动版本加1
     * 表字段 : xiaot_game_user.version
     * </pre>
     */
    private Integer version;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
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

    public Double getReturnRate() {
        return returnRate;
    }

    public void setReturnRate(Double returnRate) {
        this.returnRate = returnRate;
    }

    public Double getVolatility() {
        return volatility;
    }

    public void setVolatility(Double volatility) {
        this.volatility = volatility;
    }

    public Integer getMarketType() {
        return marketType;
    }

    public void setMarketType(Integer marketType) {
        this.marketType = marketType;
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

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}