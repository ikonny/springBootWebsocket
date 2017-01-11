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

        public Criteria andRecordidIsNull() {
            addCriterion("recordId is null");
            return (Criteria) this;
        }

        public Criteria andRecordidIsNotNull() {
            addCriterion("recordId is not null");
            return (Criteria) this;
        }

        public Criteria andRecordidEqualTo(Integer value) {
            addCriterion("recordId =", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotEqualTo(Integer value) {
            addCriterion("recordId <>", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidGreaterThan(Integer value) {
            addCriterion("recordId >", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidGreaterThanOrEqualTo(Integer value) {
            addCriterion("recordId >=", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidLessThan(Integer value) {
            addCriterion("recordId <", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidLessThanOrEqualTo(Integer value) {
            addCriterion("recordId <=", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidIn(List<Integer> values) {
            addCriterion("recordId in", values, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotIn(List<Integer> values) {
            addCriterion("recordId not in", values, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidBetween(Integer value1, Integer value2) {
            addCriterion("recordId between", value1, value2, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotBetween(Integer value1, Integer value2) {
            addCriterion("recordId not between", value1, value2, "recordid");
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

        public Criteria andFdtidIsNull() {
            addCriterion("fdtId is null");
            return (Criteria) this;
        }

        public Criteria andFdtidIsNotNull() {
            addCriterion("fdtId is not null");
            return (Criteria) this;
        }

        public Criteria andFdtidEqualTo(String value) {
            addCriterion("fdtId =", value, "fdtid");
            return (Criteria) this;
        }

        public Criteria andFdtidNotEqualTo(String value) {
            addCriterion("fdtId <>", value, "fdtid");
            return (Criteria) this;
        }

        public Criteria andFdtidGreaterThan(String value) {
            addCriterion("fdtId >", value, "fdtid");
            return (Criteria) this;
        }

        public Criteria andFdtidGreaterThanOrEqualTo(String value) {
            addCriterion("fdtId >=", value, "fdtid");
            return (Criteria) this;
        }

        public Criteria andFdtidLessThan(String value) {
            addCriterion("fdtId <", value, "fdtid");
            return (Criteria) this;
        }

        public Criteria andFdtidLessThanOrEqualTo(String value) {
            addCriterion("fdtId <=", value, "fdtid");
            return (Criteria) this;
        }

        public Criteria andFdtidLike(String value) {
            addCriterion("fdtId like", value, "fdtid");
            return (Criteria) this;
        }

        public Criteria andFdtidNotLike(String value) {
            addCriterion("fdtId not like", value, "fdtid");
            return (Criteria) this;
        }

        public Criteria andFdtidIn(List<String> values) {
            addCriterion("fdtId in", values, "fdtid");
            return (Criteria) this;
        }

        public Criteria andFdtidNotIn(List<String> values) {
            addCriterion("fdtId not in", values, "fdtid");
            return (Criteria) this;
        }

        public Criteria andFdtidBetween(String value1, String value2) {
            addCriterion("fdtId between", value1, value2, "fdtid");
            return (Criteria) this;
        }

        public Criteria andFdtidNotBetween(String value1, String value2) {
            addCriterion("fdtId not between", value1, value2, "fdtid");
            return (Criteria) this;
        }

        public Criteria andTradetimeIsNull() {
            addCriterion("tradeTime is null");
            return (Criteria) this;
        }

        public Criteria andTradetimeIsNotNull() {
            addCriterion("tradeTime is not null");
            return (Criteria) this;
        }

        public Criteria andTradetimeEqualTo(String value) {
            addCriterion("tradeTime =", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeNotEqualTo(String value) {
            addCriterion("tradeTime <>", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeGreaterThan(String value) {
            addCriterion("tradeTime >", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeGreaterThanOrEqualTo(String value) {
            addCriterion("tradeTime >=", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeLessThan(String value) {
            addCriterion("tradeTime <", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeLessThanOrEqualTo(String value) {
            addCriterion("tradeTime <=", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeLike(String value) {
            addCriterion("tradeTime like", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeNotLike(String value) {
            addCriterion("tradeTime not like", value, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeIn(List<String> values) {
            addCriterion("tradeTime in", values, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeNotIn(List<String> values) {
            addCriterion("tradeTime not in", values, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeBetween(String value1, String value2) {
            addCriterion("tradeTime between", value1, value2, "tradetime");
            return (Criteria) this;
        }

        public Criteria andTradetimeNotBetween(String value1, String value2) {
            addCriterion("tradeTime not between", value1, value2, "tradetime");
            return (Criteria) this;
        }

        public Criteria andReturnrateIsNull() {
            addCriterion("returnRate is null");
            return (Criteria) this;
        }

        public Criteria andReturnrateIsNotNull() {
            addCriterion("returnRate is not null");
            return (Criteria) this;
        }

        public Criteria andReturnrateEqualTo(Float value) {
            addCriterion("returnRate =", value, "returnrate");
            return (Criteria) this;
        }

        public Criteria andReturnrateNotEqualTo(Float value) {
            addCriterion("returnRate <>", value, "returnrate");
            return (Criteria) this;
        }

        public Criteria andReturnrateGreaterThan(Float value) {
            addCriterion("returnRate >", value, "returnrate");
            return (Criteria) this;
        }

        public Criteria andReturnrateGreaterThanOrEqualTo(Float value) {
            addCriterion("returnRate >=", value, "returnrate");
            return (Criteria) this;
        }

        public Criteria andReturnrateLessThan(Float value) {
            addCriterion("returnRate <", value, "returnrate");
            return (Criteria) this;
        }

        public Criteria andReturnrateLessThanOrEqualTo(Float value) {
            addCriterion("returnRate <=", value, "returnrate");
            return (Criteria) this;
        }

        public Criteria andReturnrateIn(List<Float> values) {
            addCriterion("returnRate in", values, "returnrate");
            return (Criteria) this;
        }

        public Criteria andReturnrateNotIn(List<Float> values) {
            addCriterion("returnRate not in", values, "returnrate");
            return (Criteria) this;
        }

        public Criteria andReturnrateBetween(Float value1, Float value2) {
            addCriterion("returnRate between", value1, value2, "returnrate");
            return (Criteria) this;
        }

        public Criteria andReturnrateNotBetween(Float value1, Float value2) {
            addCriterion("returnRate not between", value1, value2, "returnrate");
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

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Long value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Long value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Long value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Long value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Long value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Long value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Long> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Long> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Long value1, Long value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Long value1, Long value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
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

        public Criteria andQuestionkeyIsNull() {
            addCriterion("questionKey is null");
            return (Criteria) this;
        }

        public Criteria andQuestionkeyIsNotNull() {
            addCriterion("questionKey is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionkeyEqualTo(String value) {
            addCriterion("questionKey =", value, "questionkey");
            return (Criteria) this;
        }

        public Criteria andQuestionkeyNotEqualTo(String value) {
            addCriterion("questionKey <>", value, "questionkey");
            return (Criteria) this;
        }

        public Criteria andQuestionkeyGreaterThan(String value) {
            addCriterion("questionKey >", value, "questionkey");
            return (Criteria) this;
        }

        public Criteria andQuestionkeyGreaterThanOrEqualTo(String value) {
            addCriterion("questionKey >=", value, "questionkey");
            return (Criteria) this;
        }

        public Criteria andQuestionkeyLessThan(String value) {
            addCriterion("questionKey <", value, "questionkey");
            return (Criteria) this;
        }

        public Criteria andQuestionkeyLessThanOrEqualTo(String value) {
            addCriterion("questionKey <=", value, "questionkey");
            return (Criteria) this;
        }

        public Criteria andQuestionkeyLike(String value) {
            addCriterion("questionKey like", value, "questionkey");
            return (Criteria) this;
        }

        public Criteria andQuestionkeyNotLike(String value) {
            addCriterion("questionKey not like", value, "questionkey");
            return (Criteria) this;
        }

        public Criteria andQuestionkeyIn(List<String> values) {
            addCriterion("questionKey in", values, "questionkey");
            return (Criteria) this;
        }

        public Criteria andQuestionkeyNotIn(List<String> values) {
            addCriterion("questionKey not in", values, "questionkey");
            return (Criteria) this;
        }

        public Criteria andQuestionkeyBetween(String value1, String value2) {
            addCriterion("questionKey between", value1, value2, "questionkey");
            return (Criteria) this;
        }

        public Criteria andQuestionkeyNotBetween(String value1, String value2) {
            addCriterion("questionKey not between", value1, value2, "questionkey");
            return (Criteria) this;
        }

        public Criteria andSymbolLikeInsensitive(String value) {
            addCriterion("upper(symbol) like", value.toUpperCase(), "symbol");
            return (Criteria) this;
        }

        public Criteria andFdtidLikeInsensitive(String value) {
            addCriterion("upper(fdtId) like", value.toUpperCase(), "fdtid");
            return (Criteria) this;
        }

        public Criteria andTradetimeLikeInsensitive(String value) {
            addCriterion("upper(tradeTime) like", value.toUpperCase(), "tradetime");
            return (Criteria) this;
        }

        public Criteria andQuestionkeyLikeInsensitive(String value) {
            addCriterion("upper(questionKey) like", value.toUpperCase(), "questionkey");
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