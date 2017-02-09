package cn.hkfdt.xiaot.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class ForceAnalysisExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ForceAnalysisExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andForceIdIsNull() {
            addCriterion("forceId is null");
            return (Criteria) this;
        }

        public Criteria andForceIdIsNotNull() {
            addCriterion("forceId is not null");
            return (Criteria) this;
        }

        public Criteria andForceIdEqualTo(Integer value) {
            addCriterion("forceId =", value, "forceId");
            return (Criteria) this;
        }

        public Criteria andForceIdNotEqualTo(Integer value) {
            addCriterion("forceId <>", value, "forceId");
            return (Criteria) this;
        }

        public Criteria andForceIdGreaterThan(Integer value) {
            addCriterion("forceId >", value, "forceId");
            return (Criteria) this;
        }

        public Criteria andForceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("forceId >=", value, "forceId");
            return (Criteria) this;
        }

        public Criteria andForceIdLessThan(Integer value) {
            addCriterion("forceId <", value, "forceId");
            return (Criteria) this;
        }

        public Criteria andForceIdLessThanOrEqualTo(Integer value) {
            addCriterion("forceId <=", value, "forceId");
            return (Criteria) this;
        }

        public Criteria andForceIdIn(List<Integer> values) {
            addCriterion("forceId in", values, "forceId");
            return (Criteria) this;
        }

        public Criteria andForceIdNotIn(List<Integer> values) {
            addCriterion("forceId not in", values, "forceId");
            return (Criteria) this;
        }

        public Criteria andForceIdBetween(Integer value1, Integer value2) {
            addCriterion("forceId between", value1, value2, "forceId");
            return (Criteria) this;
        }

        public Criteria andForceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("forceId not between", value1, value2, "forceId");
            return (Criteria) this;
        }

        public Criteria andFdtScoreIsNull() {
            addCriterion("fdtScore is null");
            return (Criteria) this;
        }

        public Criteria andFdtScoreIsNotNull() {
            addCriterion("fdtScore is not null");
            return (Criteria) this;
        }

        public Criteria andFdtScoreEqualTo(Float value) {
            addCriterion("fdtScore =", value, "fdtScore");
            return (Criteria) this;
        }

        public Criteria andFdtScoreNotEqualTo(Float value) {
            addCriterion("fdtScore <>", value, "fdtScore");
            return (Criteria) this;
        }

        public Criteria andFdtScoreGreaterThan(Float value) {
            addCriterion("fdtScore >", value, "fdtScore");
            return (Criteria) this;
        }

        public Criteria andFdtScoreGreaterThanOrEqualTo(Float value) {
            addCriterion("fdtScore >=", value, "fdtScore");
            return (Criteria) this;
        }

        public Criteria andFdtScoreLessThan(Float value) {
            addCriterion("fdtScore <", value, "fdtScore");
            return (Criteria) this;
        }

        public Criteria andFdtScoreLessThanOrEqualTo(Float value) {
            addCriterion("fdtScore <=", value, "fdtScore");
            return (Criteria) this;
        }

        public Criteria andFdtScoreIn(List<Float> values) {
            addCriterion("fdtScore in", values, "fdtScore");
            return (Criteria) this;
        }

        public Criteria andFdtScoreNotIn(List<Float> values) {
            addCriterion("fdtScore not in", values, "fdtScore");
            return (Criteria) this;
        }

        public Criteria andFdtScoreBetween(Float value1, Float value2) {
            addCriterion("fdtScore between", value1, value2, "fdtScore");
            return (Criteria) this;
        }

        public Criteria andFdtScoreNotBetween(Float value1, Float value2) {
            addCriterion("fdtScore not between", value1, value2, "fdtScore");
            return (Criteria) this;
        }

        public Criteria andAccumulatedIncomeIsNull() {
            addCriterion("accumulatedIncome is null");
            return (Criteria) this;
        }

        public Criteria andAccumulatedIncomeIsNotNull() {
            addCriterion("accumulatedIncome is not null");
            return (Criteria) this;
        }

        public Criteria andAccumulatedIncomeEqualTo(Float value) {
            addCriterion("accumulatedIncome =", value, "accumulatedIncome");
            return (Criteria) this;
        }

        public Criteria andAccumulatedIncomeNotEqualTo(Float value) {
            addCriterion("accumulatedIncome <>", value, "accumulatedIncome");
            return (Criteria) this;
        }

        public Criteria andAccumulatedIncomeGreaterThan(Float value) {
            addCriterion("accumulatedIncome >", value, "accumulatedIncome");
            return (Criteria) this;
        }

        public Criteria andAccumulatedIncomeGreaterThanOrEqualTo(Float value) {
            addCriterion("accumulatedIncome >=", value, "accumulatedIncome");
            return (Criteria) this;
        }

        public Criteria andAccumulatedIncomeLessThan(Float value) {
            addCriterion("accumulatedIncome <", value, "accumulatedIncome");
            return (Criteria) this;
        }

        public Criteria andAccumulatedIncomeLessThanOrEqualTo(Float value) {
            addCriterion("accumulatedIncome <=", value, "accumulatedIncome");
            return (Criteria) this;
        }

        public Criteria andAccumulatedIncomeIn(List<Float> values) {
            addCriterion("accumulatedIncome in", values, "accumulatedIncome");
            return (Criteria) this;
        }

        public Criteria andAccumulatedIncomeNotIn(List<Float> values) {
            addCriterion("accumulatedIncome not in", values, "accumulatedIncome");
            return (Criteria) this;
        }

        public Criteria andAccumulatedIncomeBetween(Float value1, Float value2) {
            addCriterion("accumulatedIncome between", value1, value2, "accumulatedIncome");
            return (Criteria) this;
        }

        public Criteria andAccumulatedIncomeNotBetween(Float value1, Float value2) {
            addCriterion("accumulatedIncome not between", value1, value2, "accumulatedIncome");
            return (Criteria) this;
        }

        public Criteria andFdtIdIsNull() {
            addCriterion("fdtId is null");
            return (Criteria) this;
        }

        public Criteria andFdtIdIsNotNull() {
            addCriterion("fdtId is not null");
            return (Criteria) this;
        }

        public Criteria andFdtIdEqualTo(String value) {
            addCriterion("fdtId =", value, "fdtId");
            return (Criteria) this;
        }

        public Criteria andFdtIdNotEqualTo(String value) {
            addCriterion("fdtId <>", value, "fdtId");
            return (Criteria) this;
        }

        public Criteria andFdtIdGreaterThan(String value) {
            addCriterion("fdtId >", value, "fdtId");
            return (Criteria) this;
        }

        public Criteria andFdtIdGreaterThanOrEqualTo(String value) {
            addCriterion("fdtId >=", value, "fdtId");
            return (Criteria) this;
        }

        public Criteria andFdtIdLessThan(String value) {
            addCriterion("fdtId <", value, "fdtId");
            return (Criteria) this;
        }

        public Criteria andFdtIdLessThanOrEqualTo(String value) {
            addCriterion("fdtId <=", value, "fdtId");
            return (Criteria) this;
        }

        public Criteria andFdtIdLike(String value) {
            addCriterion("fdtId like", value, "fdtId");
            return (Criteria) this;
        }

        public Criteria andFdtIdNotLike(String value) {
            addCriterion("fdtId not like", value, "fdtId");
            return (Criteria) this;
        }

        public Criteria andFdtIdIn(List<String> values) {
            addCriterion("fdtId in", values, "fdtId");
            return (Criteria) this;
        }

        public Criteria andFdtIdNotIn(List<String> values) {
            addCriterion("fdtId not in", values, "fdtId");
            return (Criteria) this;
        }

        public Criteria andFdtIdBetween(String value1, String value2) {
            addCriterion("fdtId between", value1, value2, "fdtId");
            return (Criteria) this;
        }

        public Criteria andFdtIdNotBetween(String value1, String value2) {
            addCriterion("fdtId not between", value1, value2, "fdtId");
            return (Criteria) this;
        }

        public Criteria andTradeCountIsNull() {
            addCriterion("tradeCount is null");
            return (Criteria) this;
        }

        public Criteria andTradeCountIsNotNull() {
            addCriterion("tradeCount is not null");
            return (Criteria) this;
        }

        public Criteria andTradeCountEqualTo(Integer value) {
            addCriterion("tradeCount =", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountNotEqualTo(Integer value) {
            addCriterion("tradeCount <>", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountGreaterThan(Integer value) {
            addCriterion("tradeCount >", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("tradeCount >=", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountLessThan(Integer value) {
            addCriterion("tradeCount <", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountLessThanOrEqualTo(Integer value) {
            addCriterion("tradeCount <=", value, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountIn(List<Integer> values) {
            addCriterion("tradeCount in", values, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountNotIn(List<Integer> values) {
            addCriterion("tradeCount not in", values, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountBetween(Integer value1, Integer value2) {
            addCriterion("tradeCount between", value1, value2, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andTradeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("tradeCount not between", value1, value2, "tradeCount");
            return (Criteria) this;
        }

        public Criteria andWinCountIsNull() {
            addCriterion("winCount is null");
            return (Criteria) this;
        }

        public Criteria andWinCountIsNotNull() {
            addCriterion("winCount is not null");
            return (Criteria) this;
        }

        public Criteria andWinCountEqualTo(Integer value) {
            addCriterion("winCount =", value, "winCount");
            return (Criteria) this;
        }

        public Criteria andWinCountNotEqualTo(Integer value) {
            addCriterion("winCount <>", value, "winCount");
            return (Criteria) this;
        }

        public Criteria andWinCountGreaterThan(Integer value) {
            addCriterion("winCount >", value, "winCount");
            return (Criteria) this;
        }

        public Criteria andWinCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("winCount >=", value, "winCount");
            return (Criteria) this;
        }

        public Criteria andWinCountLessThan(Integer value) {
            addCriterion("winCount <", value, "winCount");
            return (Criteria) this;
        }

        public Criteria andWinCountLessThanOrEqualTo(Integer value) {
            addCriterion("winCount <=", value, "winCount");
            return (Criteria) this;
        }

        public Criteria andWinCountIn(List<Integer> values) {
            addCriterion("winCount in", values, "winCount");
            return (Criteria) this;
        }

        public Criteria andWinCountNotIn(List<Integer> values) {
            addCriterion("winCount not in", values, "winCount");
            return (Criteria) this;
        }

        public Criteria andWinCountBetween(Integer value1, Integer value2) {
            addCriterion("winCount between", value1, value2, "winCount");
            return (Criteria) this;
        }

        public Criteria andWinCountNotBetween(Integer value1, Integer value2) {
            addCriterion("winCount not between", value1, value2, "winCount");
            return (Criteria) this;
        }

        public Criteria andMaxDrawdownIsNull() {
            addCriterion("maxDrawdown is null");
            return (Criteria) this;
        }

        public Criteria andMaxDrawdownIsNotNull() {
            addCriterion("maxDrawdown is not null");
            return (Criteria) this;
        }

        public Criteria andMaxDrawdownEqualTo(Float value) {
            addCriterion("maxDrawdown =", value, "maxDrawdown");
            return (Criteria) this;
        }

        public Criteria andMaxDrawdownNotEqualTo(Float value) {
            addCriterion("maxDrawdown <>", value, "maxDrawdown");
            return (Criteria) this;
        }

        public Criteria andMaxDrawdownGreaterThan(Float value) {
            addCriterion("maxDrawdown >", value, "maxDrawdown");
            return (Criteria) this;
        }

        public Criteria andMaxDrawdownGreaterThanOrEqualTo(Float value) {
            addCriterion("maxDrawdown >=", value, "maxDrawdown");
            return (Criteria) this;
        }

        public Criteria andMaxDrawdownLessThan(Float value) {
            addCriterion("maxDrawdown <", value, "maxDrawdown");
            return (Criteria) this;
        }

        public Criteria andMaxDrawdownLessThanOrEqualTo(Float value) {
            addCriterion("maxDrawdown <=", value, "maxDrawdown");
            return (Criteria) this;
        }

        public Criteria andMaxDrawdownIn(List<Float> values) {
            addCriterion("maxDrawdown in", values, "maxDrawdown");
            return (Criteria) this;
        }

        public Criteria andMaxDrawdownNotIn(List<Float> values) {
            addCriterion("maxDrawdown not in", values, "maxDrawdown");
            return (Criteria) this;
        }

        public Criteria andMaxDrawdownBetween(Float value1, Float value2) {
            addCriterion("maxDrawdown between", value1, value2, "maxDrawdown");
            return (Criteria) this;
        }

        public Criteria andMaxDrawdownNotBetween(Float value1, Float value2) {
            addCriterion("maxDrawdown not between", value1, value2, "maxDrawdown");
            return (Criteria) this;
        }

        public Criteria andSharpeRatioIsNull() {
            addCriterion("sharpeRatio is null");
            return (Criteria) this;
        }

        public Criteria andSharpeRatioIsNotNull() {
            addCriterion("sharpeRatio is not null");
            return (Criteria) this;
        }

        public Criteria andSharpeRatioEqualTo(Float value) {
            addCriterion("sharpeRatio =", value, "sharpeRatio");
            return (Criteria) this;
        }

        public Criteria andSharpeRatioNotEqualTo(Float value) {
            addCriterion("sharpeRatio <>", value, "sharpeRatio");
            return (Criteria) this;
        }

        public Criteria andSharpeRatioGreaterThan(Float value) {
            addCriterion("sharpeRatio >", value, "sharpeRatio");
            return (Criteria) this;
        }

        public Criteria andSharpeRatioGreaterThanOrEqualTo(Float value) {
            addCriterion("sharpeRatio >=", value, "sharpeRatio");
            return (Criteria) this;
        }

        public Criteria andSharpeRatioLessThan(Float value) {
            addCriterion("sharpeRatio <", value, "sharpeRatio");
            return (Criteria) this;
        }

        public Criteria andSharpeRatioLessThanOrEqualTo(Float value) {
            addCriterion("sharpeRatio <=", value, "sharpeRatio");
            return (Criteria) this;
        }

        public Criteria andSharpeRatioIn(List<Float> values) {
            addCriterion("sharpeRatio in", values, "sharpeRatio");
            return (Criteria) this;
        }

        public Criteria andSharpeRatioNotIn(List<Float> values) {
            addCriterion("sharpeRatio not in", values, "sharpeRatio");
            return (Criteria) this;
        }

        public Criteria andSharpeRatioBetween(Float value1, Float value2) {
            addCriterion("sharpeRatio between", value1, value2, "sharpeRatio");
            return (Criteria) this;
        }

        public Criteria andSharpeRatioNotBetween(Float value1, Float value2) {
            addCriterion("sharpeRatio not between", value1, value2, "sharpeRatio");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andVERSIONIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVERSIONIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVERSIONEqualTo(Integer value) {
            addCriterion("VERSION =", value, "VERSION");
            return (Criteria) this;
        }

        public Criteria andVERSIONNotEqualTo(Integer value) {
            addCriterion("VERSION <>", value, "VERSION");
            return (Criteria) this;
        }

        public Criteria andVERSIONGreaterThan(Integer value) {
            addCriterion("VERSION >", value, "VERSION");
            return (Criteria) this;
        }

        public Criteria andVERSIONGreaterThanOrEqualTo(Integer value) {
            addCriterion("VERSION >=", value, "VERSION");
            return (Criteria) this;
        }

        public Criteria andVERSIONLessThan(Integer value) {
            addCriterion("VERSION <", value, "VERSION");
            return (Criteria) this;
        }

        public Criteria andVERSIONLessThanOrEqualTo(Integer value) {
            addCriterion("VERSION <=", value, "VERSION");
            return (Criteria) this;
        }

        public Criteria andVERSIONIn(List<Integer> values) {
            addCriterion("VERSION in", values, "VERSION");
            return (Criteria) this;
        }

        public Criteria andVERSIONNotIn(List<Integer> values) {
            addCriterion("VERSION not in", values, "VERSION");
            return (Criteria) this;
        }

        public Criteria andVERSIONBetween(Integer value1, Integer value2) {
            addCriterion("VERSION between", value1, value2, "VERSION");
            return (Criteria) this;
        }

        public Criteria andVERSIONNotBetween(Integer value1, Integer value2) {
            addCriterion("VERSION not between", value1, value2, "VERSION");
            return (Criteria) this;
        }

        public Criteria andFdtIdLikeInsensitive(String value) {
            addCriterion("upper(fdtId) like", value.toUpperCase(), "fdtId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}