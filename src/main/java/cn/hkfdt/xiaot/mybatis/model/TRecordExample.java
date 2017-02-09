package cn.hkfdt.xiaot.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class TRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TRecordExample() {
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

        public Criteria andRecordIdIsNull() {
            addCriterion("recordId is null");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNotNull() {
            addCriterion("recordId is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIdEqualTo(Integer value) {
            addCriterion("recordId =", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotEqualTo(Integer value) {
            addCriterion("recordId <>", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThan(Integer value) {
            addCriterion("recordId >", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("recordId >=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThan(Integer value) {
            addCriterion("recordId <", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("recordId <=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdIn(List<Integer> values) {
            addCriterion("recordId in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotIn(List<Integer> values) {
            addCriterion("recordId not in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("recordId between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("recordId not between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andSymbolIsNull() {
            addCriterion("symbol is null");
            return (Criteria) this;
        }

        public Criteria andSymbolIsNotNull() {
            addCriterion("symbol is not null");
            return (Criteria) this;
        }

        public Criteria andSymbolEqualTo(String value) {
            addCriterion("symbol =", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolNotEqualTo(String value) {
            addCriterion("symbol <>", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolGreaterThan(String value) {
            addCriterion("symbol >", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolGreaterThanOrEqualTo(String value) {
            addCriterion("symbol >=", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolLessThan(String value) {
            addCriterion("symbol <", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolLessThanOrEqualTo(String value) {
            addCriterion("symbol <=", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolLike(String value) {
            addCriterion("symbol like", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolNotLike(String value) {
            addCriterion("symbol not like", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolIn(List<String> values) {
            addCriterion("symbol in", values, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolNotIn(List<String> values) {
            addCriterion("symbol not in", values, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolBetween(String value1, String value2) {
            addCriterion("symbol between", value1, value2, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolNotBetween(String value1, String value2) {
            addCriterion("symbol not between", value1, value2, "symbol");
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

        public Criteria andTradeTimeIsNull() {
            addCriterion("tradeTime is null");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIsNotNull() {
            addCriterion("tradeTime is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTimeEqualTo(String value) {
            addCriterion("tradeTime =", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotEqualTo(String value) {
            addCriterion("tradeTime <>", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeGreaterThan(String value) {
            addCriterion("tradeTime >", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeGreaterThanOrEqualTo(String value) {
            addCriterion("tradeTime >=", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeLessThan(String value) {
            addCriterion("tradeTime <", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeLessThanOrEqualTo(String value) {
            addCriterion("tradeTime <=", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeLike(String value) {
            addCriterion("tradeTime like", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotLike(String value) {
            addCriterion("tradeTime not like", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIn(List<String> values) {
            addCriterion("tradeTime in", values, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotIn(List<String> values) {
            addCriterion("tradeTime not in", values, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeBetween(String value1, String value2) {
            addCriterion("tradeTime between", value1, value2, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotBetween(String value1, String value2) {
            addCriterion("tradeTime not between", value1, value2, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andReturnRateIsNull() {
            addCriterion("returnRate is null");
            return (Criteria) this;
        }

        public Criteria andReturnRateIsNotNull() {
            addCriterion("returnRate is not null");
            return (Criteria) this;
        }

        public Criteria andReturnRateEqualTo(Float value) {
            addCriterion("returnRate =", value, "returnRate");
            return (Criteria) this;
        }

        public Criteria andReturnRateNotEqualTo(Float value) {
            addCriterion("returnRate <>", value, "returnRate");
            return (Criteria) this;
        }

        public Criteria andReturnRateGreaterThan(Float value) {
            addCriterion("returnRate >", value, "returnRate");
            return (Criteria) this;
        }

        public Criteria andReturnRateGreaterThanOrEqualTo(Float value) {
            addCriterion("returnRate >=", value, "returnRate");
            return (Criteria) this;
        }

        public Criteria andReturnRateLessThan(Float value) {
            addCriterion("returnRate <", value, "returnRate");
            return (Criteria) this;
        }

        public Criteria andReturnRateLessThanOrEqualTo(Float value) {
            addCriterion("returnRate <=", value, "returnRate");
            return (Criteria) this;
        }

        public Criteria andReturnRateIn(List<Float> values) {
            addCriterion("returnRate in", values, "returnRate");
            return (Criteria) this;
        }

        public Criteria andReturnRateNotIn(List<Float> values) {
            addCriterion("returnRate not in", values, "returnRate");
            return (Criteria) this;
        }

        public Criteria andReturnRateBetween(Float value1, Float value2) {
            addCriterion("returnRate between", value1, value2, "returnRate");
            return (Criteria) this;
        }

        public Criteria andReturnRateNotBetween(Float value1, Float value2) {
            addCriterion("returnRate not between", value1, value2, "returnRate");
            return (Criteria) this;
        }

        public Criteria andVolatilityIsNull() {
            addCriterion("volatility is null");
            return (Criteria) this;
        }

        public Criteria andVolatilityIsNotNull() {
            addCriterion("volatility is not null");
            return (Criteria) this;
        }

        public Criteria andVolatilityEqualTo(Float value) {
            addCriterion("volatility =", value, "volatility");
            return (Criteria) this;
        }

        public Criteria andVolatilityNotEqualTo(Float value) {
            addCriterion("volatility <>", value, "volatility");
            return (Criteria) this;
        }

        public Criteria andVolatilityGreaterThan(Float value) {
            addCriterion("volatility >", value, "volatility");
            return (Criteria) this;
        }

        public Criteria andVolatilityGreaterThanOrEqualTo(Float value) {
            addCriterion("volatility >=", value, "volatility");
            return (Criteria) this;
        }

        public Criteria andVolatilityLessThan(Float value) {
            addCriterion("volatility <", value, "volatility");
            return (Criteria) this;
        }

        public Criteria andVolatilityLessThanOrEqualTo(Float value) {
            addCriterion("volatility <=", value, "volatility");
            return (Criteria) this;
        }

        public Criteria andVolatilityIn(List<Float> values) {
            addCriterion("volatility in", values, "volatility");
            return (Criteria) this;
        }

        public Criteria andVolatilityNotIn(List<Float> values) {
            addCriterion("volatility not in", values, "volatility");
            return (Criteria) this;
        }

        public Criteria andVolatilityBetween(Float value1, Float value2) {
            addCriterion("volatility between", value1, value2, "volatility");
            return (Criteria) this;
        }

        public Criteria andVolatilityNotBetween(Float value1, Float value2) {
            addCriterion("volatility not between", value1, value2, "volatility");
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

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Double value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Double value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Double value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Double value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Double value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Double> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Double> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Double value1, Double value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Double value1, Double value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andQuestionKeyIsNull() {
            addCriterion("questionKey is null");
            return (Criteria) this;
        }

        public Criteria andQuestionKeyIsNotNull() {
            addCriterion("questionKey is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionKeyEqualTo(String value) {
            addCriterion("questionKey =", value, "questionKey");
            return (Criteria) this;
        }

        public Criteria andQuestionKeyNotEqualTo(String value) {
            addCriterion("questionKey <>", value, "questionKey");
            return (Criteria) this;
        }

        public Criteria andQuestionKeyGreaterThan(String value) {
            addCriterion("questionKey >", value, "questionKey");
            return (Criteria) this;
        }

        public Criteria andQuestionKeyGreaterThanOrEqualTo(String value) {
            addCriterion("questionKey >=", value, "questionKey");
            return (Criteria) this;
        }

        public Criteria andQuestionKeyLessThan(String value) {
            addCriterion("questionKey <", value, "questionKey");
            return (Criteria) this;
        }

        public Criteria andQuestionKeyLessThanOrEqualTo(String value) {
            addCriterion("questionKey <=", value, "questionKey");
            return (Criteria) this;
        }

        public Criteria andQuestionKeyLike(String value) {
            addCriterion("questionKey like", value, "questionKey");
            return (Criteria) this;
        }

        public Criteria andQuestionKeyNotLike(String value) {
            addCriterion("questionKey not like", value, "questionKey");
            return (Criteria) this;
        }

        public Criteria andQuestionKeyIn(List<String> values) {
            addCriterion("questionKey in", values, "questionKey");
            return (Criteria) this;
        }

        public Criteria andQuestionKeyNotIn(List<String> values) {
            addCriterion("questionKey not in", values, "questionKey");
            return (Criteria) this;
        }

        public Criteria andQuestionKeyBetween(String value1, String value2) {
            addCriterion("questionKey between", value1, value2, "questionKey");
            return (Criteria) this;
        }

        public Criteria andQuestionKeyNotBetween(String value1, String value2) {
            addCriterion("questionKey not between", value1, value2, "questionKey");
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

        public Criteria andSymbolLikeInsensitive(String value) {
            addCriterion("upper(symbol) like", value.toUpperCase(), "symbol");
            return (Criteria) this;
        }

        public Criteria andFdtIdLikeInsensitive(String value) {
            addCriterion("upper(fdtId) like", value.toUpperCase(), "fdtId");
            return (Criteria) this;
        }

        public Criteria andTradeTimeLikeInsensitive(String value) {
            addCriterion("upper(tradeTime) like", value.toUpperCase(), "tradeTime");
            return (Criteria) this;
        }

        public Criteria andQuestionKeyLikeInsensitive(String value) {
            addCriterion("upper(questionKey) like", value.toUpperCase(), "questionKey");
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