package cn.hkfdt.xiaot.mybatis.model.ltschina;

import java.util.ArrayList;
import java.util.List;

public class TQuestionsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TQuestionsExample() {
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

        public Criteria andQuestionIdIsNull() {
            addCriterion("questionId is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIsNotNull() {
            addCriterion("questionId is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdEqualTo(Integer value) {
            addCriterion("questionId =", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotEqualTo(Integer value) {
            addCriterion("questionId <>", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThan(Integer value) {
            addCriterion("questionId >", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("questionId >=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThan(Integer value) {
            addCriterion("questionId <", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThanOrEqualTo(Integer value) {
            addCriterion("questionId <=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIn(List<Integer> values) {
            addCriterion("questionId in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotIn(List<Integer> values) {
            addCriterion("questionId not in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdBetween(Integer value1, Integer value2) {
            addCriterion("questionId between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("questionId not between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andExchangeCodeIsNull() {
            addCriterion("exchangeCode is null");
            return (Criteria) this;
        }

        public Criteria andExchangeCodeIsNotNull() {
            addCriterion("exchangeCode is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeCodeEqualTo(String value) {
            addCriterion("exchangeCode =", value, "exchangeCode");
            return (Criteria) this;
        }

        public Criteria andExchangeCodeNotEqualTo(String value) {
            addCriterion("exchangeCode <>", value, "exchangeCode");
            return (Criteria) this;
        }

        public Criteria andExchangeCodeGreaterThan(String value) {
            addCriterion("exchangeCode >", value, "exchangeCode");
            return (Criteria) this;
        }

        public Criteria andExchangeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("exchangeCode >=", value, "exchangeCode");
            return (Criteria) this;
        }

        public Criteria andExchangeCodeLessThan(String value) {
            addCriterion("exchangeCode <", value, "exchangeCode");
            return (Criteria) this;
        }

        public Criteria andExchangeCodeLessThanOrEqualTo(String value) {
            addCriterion("exchangeCode <=", value, "exchangeCode");
            return (Criteria) this;
        }

        public Criteria andExchangeCodeLike(String value) {
            addCriterion("exchangeCode like", value, "exchangeCode");
            return (Criteria) this;
        }

        public Criteria andExchangeCodeNotLike(String value) {
            addCriterion("exchangeCode not like", value, "exchangeCode");
            return (Criteria) this;
        }

        public Criteria andExchangeCodeIn(List<String> values) {
            addCriterion("exchangeCode in", values, "exchangeCode");
            return (Criteria) this;
        }

        public Criteria andExchangeCodeNotIn(List<String> values) {
            addCriterion("exchangeCode not in", values, "exchangeCode");
            return (Criteria) this;
        }

        public Criteria andExchangeCodeBetween(String value1, String value2) {
            addCriterion("exchangeCode between", value1, value2, "exchangeCode");
            return (Criteria) this;
        }

        public Criteria andExchangeCodeNotBetween(String value1, String value2) {
            addCriterion("exchangeCode not between", value1, value2, "exchangeCode");
            return (Criteria) this;
        }

        public Criteria andShortSymbolIsNull() {
            addCriterion("shortSymbol is null");
            return (Criteria) this;
        }

        public Criteria andShortSymbolIsNotNull() {
            addCriterion("shortSymbol is not null");
            return (Criteria) this;
        }

        public Criteria andShortSymbolEqualTo(String value) {
            addCriterion("shortSymbol =", value, "shortSymbol");
            return (Criteria) this;
        }

        public Criteria andShortSymbolNotEqualTo(String value) {
            addCriterion("shortSymbol <>", value, "shortSymbol");
            return (Criteria) this;
        }

        public Criteria andShortSymbolGreaterThan(String value) {
            addCriterion("shortSymbol >", value, "shortSymbol");
            return (Criteria) this;
        }

        public Criteria andShortSymbolGreaterThanOrEqualTo(String value) {
            addCriterion("shortSymbol >=", value, "shortSymbol");
            return (Criteria) this;
        }

        public Criteria andShortSymbolLessThan(String value) {
            addCriterion("shortSymbol <", value, "shortSymbol");
            return (Criteria) this;
        }

        public Criteria andShortSymbolLessThanOrEqualTo(String value) {
            addCriterion("shortSymbol <=", value, "shortSymbol");
            return (Criteria) this;
        }

        public Criteria andShortSymbolLike(String value) {
            addCriterion("shortSymbol like", value, "shortSymbol");
            return (Criteria) this;
        }

        public Criteria andShortSymbolNotLike(String value) {
            addCriterion("shortSymbol not like", value, "shortSymbol");
            return (Criteria) this;
        }

        public Criteria andShortSymbolIn(List<String> values) {
            addCriterion("shortSymbol in", values, "shortSymbol");
            return (Criteria) this;
        }

        public Criteria andShortSymbolNotIn(List<String> values) {
            addCriterion("shortSymbol not in", values, "shortSymbol");
            return (Criteria) this;
        }

        public Criteria andShortSymbolBetween(String value1, String value2) {
            addCriterion("shortSymbol between", value1, value2, "shortSymbol");
            return (Criteria) this;
        }

        public Criteria andShortSymbolNotBetween(String value1, String value2) {
            addCriterion("shortSymbol not between", value1, value2, "shortSymbol");
            return (Criteria) this;
        }

        public Criteria andTradeDayIsNull() {
            addCriterion("tradeDay is null");
            return (Criteria) this;
        }

        public Criteria andTradeDayIsNotNull() {
            addCriterion("tradeDay is not null");
            return (Criteria) this;
        }

        public Criteria andTradeDayEqualTo(String value) {
            addCriterion("tradeDay =", value, "tradeDay");
            return (Criteria) this;
        }

        public Criteria andTradeDayNotEqualTo(String value) {
            addCriterion("tradeDay <>", value, "tradeDay");
            return (Criteria) this;
        }

        public Criteria andTradeDayGreaterThan(String value) {
            addCriterion("tradeDay >", value, "tradeDay");
            return (Criteria) this;
        }

        public Criteria andTradeDayGreaterThanOrEqualTo(String value) {
            addCriterion("tradeDay >=", value, "tradeDay");
            return (Criteria) this;
        }

        public Criteria andTradeDayLessThan(String value) {
            addCriterion("tradeDay <", value, "tradeDay");
            return (Criteria) this;
        }

        public Criteria andTradeDayLessThanOrEqualTo(String value) {
            addCriterion("tradeDay <=", value, "tradeDay");
            return (Criteria) this;
        }

        public Criteria andTradeDayLike(String value) {
            addCriterion("tradeDay like", value, "tradeDay");
            return (Criteria) this;
        }

        public Criteria andTradeDayNotLike(String value) {
            addCriterion("tradeDay not like", value, "tradeDay");
            return (Criteria) this;
        }

        public Criteria andTradeDayIn(List<String> values) {
            addCriterion("tradeDay in", values, "tradeDay");
            return (Criteria) this;
        }

        public Criteria andTradeDayNotIn(List<String> values) {
            addCriterion("tradeDay not in", values, "tradeDay");
            return (Criteria) this;
        }

        public Criteria andTradeDayBetween(String value1, String value2) {
            addCriterion("tradeDay between", value1, value2, "tradeDay");
            return (Criteria) this;
        }

        public Criteria andTradeDayNotBetween(String value1, String value2) {
            addCriterion("tradeDay not between", value1, value2, "tradeDay");
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

        public Criteria andTopicTypeIsNull() {
            addCriterion("topicType is null");
            return (Criteria) this;
        }

        public Criteria andTopicTypeIsNotNull() {
            addCriterion("topicType is not null");
            return (Criteria) this;
        }

        public Criteria andTopicTypeEqualTo(String value) {
            addCriterion("topicType =", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeNotEqualTo(String value) {
            addCriterion("topicType <>", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeGreaterThan(String value) {
            addCriterion("topicType >", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeGreaterThanOrEqualTo(String value) {
            addCriterion("topicType >=", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeLessThan(String value) {
            addCriterion("topicType <", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeLessThanOrEqualTo(String value) {
            addCriterion("topicType <=", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeLike(String value) {
            addCriterion("topicType like", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeNotLike(String value) {
            addCriterion("topicType not like", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeIn(List<String> values) {
            addCriterion("topicType in", values, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeNotIn(List<String> values) {
            addCriterion("topicType not in", values, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeBetween(String value1, String value2) {
            addCriterion("topicType between", value1, value2, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeNotBetween(String value1, String value2) {
            addCriterion("topicType not between", value1, value2, "topicType");
            return (Criteria) this;
        }

        public Criteria andInitTypeIsNull() {
            addCriterion("initType is null");
            return (Criteria) this;
        }

        public Criteria andInitTypeIsNotNull() {
            addCriterion("initType is not null");
            return (Criteria) this;
        }

        public Criteria andInitTypeEqualTo(Integer value) {
            addCriterion("initType =", value, "initType");
            return (Criteria) this;
        }

        public Criteria andInitTypeNotEqualTo(Integer value) {
            addCriterion("initType <>", value, "initType");
            return (Criteria) this;
        }

        public Criteria andInitTypeGreaterThan(Integer value) {
            addCriterion("initType >", value, "initType");
            return (Criteria) this;
        }

        public Criteria andInitTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("initType >=", value, "initType");
            return (Criteria) this;
        }

        public Criteria andInitTypeLessThan(Integer value) {
            addCriterion("initType <", value, "initType");
            return (Criteria) this;
        }

        public Criteria andInitTypeLessThanOrEqualTo(Integer value) {
            addCriterion("initType <=", value, "initType");
            return (Criteria) this;
        }

        public Criteria andInitTypeIn(List<Integer> values) {
            addCriterion("initType in", values, "initType");
            return (Criteria) this;
        }

        public Criteria andInitTypeNotIn(List<Integer> values) {
            addCriterion("initType not in", values, "initType");
            return (Criteria) this;
        }

        public Criteria andInitTypeBetween(Integer value1, Integer value2) {
            addCriterion("initType between", value1, value2, "initType");
            return (Criteria) this;
        }

        public Criteria andInitTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("initType not between", value1, value2, "initType");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andExchangeCodeLikeInsensitive(String value) {
            addCriterion("upper(exchangeCode) like", value.toUpperCase(), "exchangeCode");
            return (Criteria) this;
        }

        public Criteria andShortSymbolLikeInsensitive(String value) {
            addCriterion("upper(shortSymbol) like", value.toUpperCase(), "shortSymbol");
            return (Criteria) this;
        }

        public Criteria andTradeDayLikeInsensitive(String value) {
            addCriterion("upper(tradeDay) like", value.toUpperCase(), "tradeDay");
            return (Criteria) this;
        }

        public Criteria andTopicTypeLikeInsensitive(String value) {
            addCriterion("upper(topicType) like", value.toUpperCase(), "topicType");
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